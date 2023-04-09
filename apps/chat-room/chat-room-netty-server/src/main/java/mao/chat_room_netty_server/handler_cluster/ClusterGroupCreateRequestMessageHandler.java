package mao.chat_room_netty_server.handler_cluster;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.GroupCreateRequestMessage;
import mao.chat_room_common.message.GroupCreateResponseMessage;
import mao.chat_room_netty_server.handler.GroupCreateRequestMessageHandler;
import mao.chat_room_netty_server.service.RedisService;
import mao.chat_room_netty_server.session.Group;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler_cluster
 * Class(类名): ClusterGroupCreateRequestMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/3
 * Time(创建时间)： 21:54
 * Version(版本): 1.0
 * Description(描述)： 群聊创建请求入栈消息处理器
 */

@Slf4j
@Service
@ChannelHandler.Sharable
public class ClusterGroupCreateRequestMessageHandler extends GroupCreateRequestMessageHandler
{
    @Resource
    private GroupSession groupSession;

    @Resource
    private Session session;

    @Resource
    private RedisService redisService;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                GroupCreateRequestMessage groupCreateRequestMessage) throws Exception
    {
        //检查登录状态
        if (!session.isLogin(ctx.channel()))
        {
            //未登录
            ctx.writeAndFlush(GroupCreateResponseMessage.fail("请登录")
                    .setSequenceId(groupCreateRequestMessage.getSequenceId()));
            return;
        }

        //组名
        String groupName = groupCreateRequestMessage.getGroupName();
        //群成员
        Set<String> members = groupCreateRequestMessage.getMembers();
        boolean hasGroup = groupSession.hasGroup(groupName);
        //判断群聊名称是否存在
        if (hasGroup)
        {
            //已存在
            ctx.writeAndFlush(GroupCreateResponseMessage.fail("群聊名称\"" + groupName + "\"已经存在! 换个名字吧")
                    .setSequenceId(groupCreateRequestMessage.getSequenceId()));
        }
        else
        {
            //不存在
            //创建群聊
            Group group = groupSession.createGroup(groupName, members);
            //在线的成员列表
            Set<String> members1 = group.getMembers();
            ctx.writeAndFlush(GroupCreateResponseMessage.success(members1)
                    .setSequenceId(groupCreateRequestMessage.getSequenceId()));
            //群聊创建统计
            redisService.groupCreateCount();
        }
    }
}
