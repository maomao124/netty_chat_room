package mao.chat_room_netty_server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.GroupCreateResponseMessage;
import mao.chat_room_common.message.GroupJoinRequestMessage;
import mao.chat_room_common.message.GroupJoinResponseMessage;
import mao.chat_room_netty_server.session.Group;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler
 * Class(类名): GroupJoinRequestMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 14:23
 * Version(版本): 1.0
 * Description(描述)： 群聊加入请求入栈消息处理器
 */

@Slf4j
@Service
@ChannelHandler.Sharable
public class GroupJoinRequestMessageHandler extends SimpleChannelInboundHandler<GroupJoinRequestMessage>
{

    @Resource
    private Session session;

    @Resource
    private GroupSession groupSession;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                GroupJoinRequestMessage groupJoinRequestMessage) throws Exception
    {
        //检查登录状态
        if (!session.isLogin(ctx.channel()))
        {
            //未登录
            ctx.writeAndFlush(GroupJoinResponseMessage.fail("请登录")
                    .setSequenceId(groupJoinRequestMessage.getSequenceId()));
            return;
        }

        String groupName = groupJoinRequestMessage.getGroupName();
        String username = groupJoinRequestMessage.getUsername();
        Group group = groupSession.joinMember(groupName, username);
        //判断是否成功
        if (group == null)
        {
            //不成功
            ctx.writeAndFlush(GroupJoinResponseMessage.fail("群聊\"" + groupName + "\"加入失败")
                    .setSequenceId(groupJoinRequestMessage.getSequenceId()));
        }
        else
        {
            //成功
            ctx.writeAndFlush(GroupJoinResponseMessage.success()
                    .setSequenceId(groupJoinRequestMessage.getSequenceId()));
        }
    }
}
