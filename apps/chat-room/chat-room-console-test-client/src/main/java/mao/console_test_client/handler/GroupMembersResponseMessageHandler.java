package mao.console_test_client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import mao.chat_room_common.message.GroupMembersResponseMessage;
import mao.console_test_client.StressTestClient;

import java.awt.*;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.handler
 * Class(类名): GroupMembersResponseMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/31
 * Time(创建时间)： 16:15
 * Version(版本): 1.0
 * Description(描述)： 得到群聊成员响应消息处理器
 */

@ChannelHandler.Sharable
public class GroupMembersResponseMessageHandler extends SimpleChannelInboundHandler<GroupMembersResponseMessage>
{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                GroupMembersResponseMessage groupMembersResponseMessage) throws Exception
    {
        try
        {
            if (groupMembersResponseMessage.isSuccess())
            {
                String groupName = groupMembersResponseMessage.getGroupName();
                Set<String> members = groupMembersResponseMessage.getMembers();
                System.out.println("当前群聊\"" + groupName + "\"的成员有：" + members);
            }
            else
            {
                //失败
                System.out.println("失败！失败原因：" + groupMembersResponseMessage.getReason());
                Toolkit.getDefaultToolkit().beep();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            LockSupport.unpark(StressTestClient.getThread());
        }
    }
}
