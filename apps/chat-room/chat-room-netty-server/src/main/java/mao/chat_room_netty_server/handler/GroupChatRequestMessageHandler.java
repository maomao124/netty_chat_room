package mao.chat_room_netty_server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.GroupChatRequestMessage;
import mao.chat_room_common.message.GroupChatResponseMessage;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler
 * Class(类名): GroupChatRequestMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/29
 * Time(创建时间)： 22:34
 * Version(版本): 1.0
 * Description(描述)： 群聊聊天请求入栈消息处理器
 */

@Slf4j
@Service
@ChannelHandler.Sharable
public class GroupChatRequestMessageHandler extends SimpleChannelInboundHandler<GroupChatRequestMessage>
{
    @Resource
    private Session session;

    @Resource
    private GroupSession groupSession;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                GroupChatRequestMessage groupChatRequestMessage) throws Exception
    {
        String groupName = groupChatRequestMessage.getGroupName();
        String content = groupChatRequestMessage.getContent();
        String from = groupChatRequestMessage.getFrom();

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
