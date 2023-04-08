package mao.chat_room_netty_server.handler_cluster;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.GroupChatRequestMessage;
import mao.chat_room_common.message.GroupChatResponseMessage;
import mao.chat_room_netty_server.entity.ClusterGroup;
import mao.chat_room_netty_server.handler.GroupChatRequestMessageHandler;
import mao.chat_room_netty_server.service.RedisService;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import mao.chat_room_server_api.constants.UrlConstants;
import mao.tools_core.base.R;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler_cluster
 * Class(类名): ClusterGroupChatRequestMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/7
 * Time(创建时间)： 18:16
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
@ChannelHandler.Sharable
public class ClusterGroupChatRequestMessageHandler extends GroupChatRequestMessageHandler
{

    @Resource
    private Session session;

    @Resource
    private GroupSession groupSession;

    @Resource
    private RedisService redisService;

    @Resource
    private RestTemplate restTemplate;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                GroupChatRequestMessage groupChatRequestMessage) throws Exception
    {
        //检查登录状态
        if (!session.isLogin(ctx.channel()))
        {
            //未登录
            ctx.writeAndFlush(GroupChatResponseMessage.fail("请登录")
                    .setSequenceId(groupChatRequestMessage.getSequenceId()));
            return;
        }

        String groupName = groupChatRequestMessage.getGroupName();
        String content = groupChatRequestMessage.getContent();
        String from = groupChatRequestMessage.getFrom();

        //得到群聊的成员和成员位置和群聊位置
        ClusterGroup clusterGroup = groupSession.getMembersAndHost(groupName);
        //判断群聊是否存在
        if (clusterGroup == null)
        {
            //不存在
            ctx.writeAndFlush(GroupChatResponseMessage.fail("群聊已经不存在")
                    .setSequenceId(groupChatRequestMessage.getSequenceId()));
            return;
        }
        //群聊存在
        //得到群聊的成员和成员位置
        Map<String, String> groupMembersAndHost = clusterGroup.getGroupMembersAndHost();
        //判断自己是否在里面
        if (groupMembersAndHost.get(from) == null)
        {
            //不在
            ctx.writeAndFlush(GroupChatResponseMessage.fail("请先加入该群聊")
                    .setSequenceId(groupChatRequestMessage.getSequenceId()));
            return;
        }
        //分桶,key为host，value一个map，map里面key为用户名，value为为GroupChatResponseMessage
        Map<String, Map<String, GroupChatResponseMessage>> map = new HashMap<>();
        //发给每一位成员的时间要一致
        LocalDateTime now = LocalDateTime.now();
        //这里并发很大，对于服务器而言，使用异步操作反而会因为线程的上下文切换而影响性能
        groupMembersAndHost.forEach(new BiConsumer<String, String>()
        {
            /**
             * 遍历
             *
             * @param username 用户名
             * @param host     用户的位置
             */
            @Override
            public void accept(String username, String host)
            {
                //在本实例内取，如果没有取到，证明在其他实例上，或者不存在
                Channel channel = session.getChannel(username);
                if (channel != null)
                {
                    //在本实例上
                    channel.writeAndFlush(GroupChatResponseMessage.success(from, content, groupName)
                            .setSequenceId(groupChatRequestMessage.getSequenceId())
                            .setTime(now));
                    log.debug("用户" + username + "在本实例内，直接发送");
                }
                else
                {
                    //不在本实例上，往桶里添加
                    //如果没有，就创建一个空的
                    Map<String, GroupChatResponseMessage> userMap =
                            map.computeIfAbsent(host, k -> new HashMap<>());
                    //构建
                    GroupChatResponseMessage groupChatResponseMessage =
                            (GroupChatResponseMessage) GroupChatResponseMessage
                                    .success(from, content, groupName)
                                    .setSequenceId(groupChatRequestMessage.getSequenceId())
                                    .setTime(now);
                    userMap.put(username, groupChatResponseMessage);
                    log.debug("用户" + username + "添加到分桶");
                }
            }
        });
        log.debug("分桶结果：" + map);
        //判断是否需要发起http请求
        if (map.size() != 0)
        {
            log.debug("准备发起请求");
            //这里并发很大，对于服务器而言，使用异步操作反而会因为线程的上下文切换而影响性能
            map.forEach(new BiConsumer<String, Map<String, GroupChatResponseMessage>>()
            {

                /**
                 * 遍历分桶
                 *
                 * @param host                        位置
                 * @param groupChatResponseMessageMap 群组聊天响应消息映射
                 */
                @Override
                public void accept(String host, Map<String, GroupChatResponseMessage> groupChatResponseMessageMap)
                {
                    //远程调用
                    String url = UrlConstants.buildGroupChatRequestMessageUrl(host);
                    log.debug("url:" + url);
                    log.debug("正在发起请求：" + host);
                    R r = restTemplate.postForObject(url, groupChatResponseMessageMap, R.class);
                    if (r.getIsError())
                    {
                        //错误
                        log.warn("发送群聊消息时出现错误:" + r.getMsg());
                    }
                    else
                    {
                        //正确
                        log.debug(host + "  ：请求完成");
                    }
                }
            });
        }
    }
}
