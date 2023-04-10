package mao.console_test_client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import mao.chat_room_common.message.GroupCreateResponseMessage;
import mao.console_test_client.StressTestClient;

import java.awt.*;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.handler
 * Class(类名): GroupCreateResponseMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/31
 * Time(创建时间)： 16:03
 * Version(版本): 1.0
 * Description(描述)： 群聊创建响应消息处理器
 */

@ChannelHandler.Sharable
public class GroupCreateResponseMessageHandler extends SimpleChannelInboundHandler<GroupCreateResponseMessage>
{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupCreateResponseMessage groupCreateResponseMessage)
            throws Exception
    {
        try
        {
            if (groupCreateResponseMessage.isSuccess())
            {
                Set<String> members = groupCreateResponseMessage.getMembers();
                if (groupCreateResponseMessage.getReason() != null)
                {
                    System.out.println(groupCreateResponseMessage.getReason());
                }
                else
                {
                    System.out.println("群聊创建成功！当前群成员：" + members);
                }
            }
            else
            {
                //失败
                System.out.println("群聊创建失败！失败原因：" + groupCreateResponseMessage.getReason());
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
