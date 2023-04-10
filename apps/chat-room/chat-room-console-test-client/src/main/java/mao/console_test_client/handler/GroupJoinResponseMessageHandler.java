package mao.console_test_client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import mao.chat_room_common.message.GroupJoinResponseMessage;
import mao.console_test_client.StressTestClient;

import java.awt.*;
import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.handler
 * Class(类名): GroupJoinResponseMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/31
 * Time(创建时间)： 19:16
 * Version(版本): 1.0
 * Description(描述)： 群聊加入响应消息处理器
 */

@ChannelHandler.Sharable
public class GroupJoinResponseMessageHandler extends SimpleChannelInboundHandler<GroupJoinResponseMessage>
{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                GroupJoinResponseMessage groupJoinResponseMessage) throws Exception
    {
        try
        {
            if (groupJoinResponseMessage.isSuccess())
            {
                System.out.println("群聊加入成功");
            }
            else
            {
                //失败
                System.out.println("群聊加入失败！失败原因：" + groupJoinResponseMessage.getReason());
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
