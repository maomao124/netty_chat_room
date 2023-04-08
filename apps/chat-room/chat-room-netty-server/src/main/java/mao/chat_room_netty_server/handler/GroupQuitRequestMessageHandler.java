package mao.chat_room_netty_server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.GroupMembersResponseMessage;
import mao.chat_room_common.message.GroupQuitRequestMessage;
import mao.chat_room_common.message.GroupQuitResponseMessage;
import mao.chat_room_netty_server.session.Group;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler
 * Class(类名): GroupQuitRequestMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 14:35
 * Version(版本): 1.0
 * Description(描述)： 群聊退出请求入栈消息处理器
 */

@Slf4j
//@Service
@ChannelHandler.Sharable
public class GroupQuitRequestMessageHandler extends SimpleChannelInboundHandler<GroupQuitRequestMessage>
{

    @Resource
    private Session session;

    @Resource
    private GroupSession groupSession;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                GroupQuitRequestMessage groupQuitRequestMessage) throws Exception
    {
        //检查登录状态
        if (!session.isLogin(ctx.channel()))
        {
            //未登录
            ctx.writeAndFlush(GroupQuitResponseMessage.fail("请登录")
                    .setSequenceId(groupQuitRequestMessage.getSequenceId()));
            return;
        }

        String groupName = groupQuitRequestMessage.getGroupName();
        String username = groupQuitRequestMessage.getUsername();
        Group group = groupSession.removeMember(groupName, username);
        if (group == null)
        {
            //失败
            ctx.writeAndFlush(GroupQuitResponseMessage.fail("群聊\"" + groupName + "\"不存在")
                    .setSequenceId(groupQuitRequestMessage.getSequenceId()));
        }
        else
        {
            //成功
            ctx.writeAndFlush(GroupQuitResponseMessage.success()
                    .setSequenceId(groupQuitRequestMessage.getSequenceId()));
        }
    }
}
