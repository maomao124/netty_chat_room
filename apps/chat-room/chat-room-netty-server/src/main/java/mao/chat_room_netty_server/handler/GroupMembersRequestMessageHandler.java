package mao.chat_room_netty_server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.GroupJoinResponseMessage;
import mao.chat_room_common.message.GroupMembersRequestMessage;
import mao.chat_room_common.message.GroupMembersResponseMessage;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler
 * Class(类名): GroupMembersRequestMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 14:29
 * Version(版本): 1.0
 * Description(描述)： 得到群聊所有成员请求入栈消息处理器
 */

@Slf4j
//@Service
@ChannelHandler.Sharable
public class GroupMembersRequestMessageHandler extends SimpleChannelInboundHandler<GroupMembersRequestMessage>
{
    @Resource
    private Session session;

    @Resource
    private GroupSession groupSession;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                GroupMembersRequestMessage groupMembersRequestMessage) throws Exception
    {
        //检查登录状态
        if (!session.isLogin(ctx.channel()))
        {
            //未登录
            ctx.writeAndFlush(GroupMembersResponseMessage.fail("请登录")
                    .setSequenceId(groupMembersRequestMessage.getSequenceId()));
            return;
        }

        String groupName = groupMembersRequestMessage.getGroupName();
        if (!groupSession.hasGroup(groupName))
        {
            ctx.writeAndFlush(GroupMembersResponseMessage.fail("群聊\"" + groupName + "\"不存在", groupName)
                    .setSequenceId(groupMembersRequestMessage.getSequenceId()));
            return;
        }
        Set<String> members = groupSession.getMembers(groupName);
        log.debug(members.toString());
        ctx.writeAndFlush(GroupMembersResponseMessage.success(groupName, members)
                .setSequenceId(groupMembersRequestMessage.getSequenceId()));
    }
}
