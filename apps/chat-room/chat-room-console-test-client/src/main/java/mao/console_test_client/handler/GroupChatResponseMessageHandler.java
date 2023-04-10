package mao.console_test_client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import mao.chat_room_common.message.GroupChatResponseMessage;
import mao.console_test_client.StressTestClient;
import mao.console_test_client.app.MainApplication;

import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.handler
 * Class(类名): GroupChatResponseMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/31
 * Time(创建时间)： 15:57
 * Version(版本): 1.0
 * Description(描述)： 群聊聊天响应消息处理器
 */

@ChannelHandler.Sharable
public class GroupChatResponseMessageHandler extends SimpleChannelInboundHandler<GroupChatResponseMessage>
{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                GroupChatResponseMessage groupChatResponseMessage) throws Exception
    {
        try
        {
            if (groupChatResponseMessage.isSuccess())
            {
                String from = groupChatResponseMessage.getFrom();
                String groupName = groupChatResponseMessage.getGroupName();
                String content = groupChatResponseMessage.getContent();
                if (from.equals(MainApplication.getLoginUsername()))
                {
                    //发送人就是自己
                    //System.out.println("群聊消息发送成功");
                }
                else
                {
                    //不是自己，别人发送过来的
                    System.out.println(groupName + " ---> " + from + " : " + content);
                }
            }
            else
            {
                //失败
                System.out.println("发送失败！失败原因：" + groupChatResponseMessage.getReason());
                //Toolkit.getDefaultToolkit().beep();
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
