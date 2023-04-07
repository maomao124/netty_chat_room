package mao.chat_room_netty_server.handler_cluster;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.GroupChatRequestMessage;
import mao.chat_room_common.message.GroupChatResponseMessage;
import mao.chat_room_netty_server.handler.GroupChatRequestMessageHandler;
import mao.chat_room_netty_server.service.RedisService;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

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


        List<Channel> channelList = groupSession.getMembersChannel(groupName);
        //发给每一位成员的时间要一致
        LocalDateTime now = LocalDateTime.now();
        //遍历发送给每一个群成员
        for (Channel channel : channelList)
        {
            channel.writeAndFlush(GroupChatResponseMessage.success(from, content, groupName)
                    .setSequenceId(groupChatRequestMessage.getSequenceId())
                    .setTime(now));
        }
    }
}
