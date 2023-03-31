package mao.console_client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import mao.chat_room_common.message.GroupQuitResponseMessage;
import mao.console_client.Client;

import java.awt.*;
import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.handler
 * Class(类名): GroupQuitResponseMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/31
 * Time(创建时间)： 19:20
 * Version(版本): 1.0
 * Description(描述)： 群聊退出响应消息处理器
 */

@ChannelHandler.Sharable
public class GroupQuitResponseMessageHandler extends SimpleChannelInboundHandler<GroupQuitResponseMessage>
{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                GroupQuitResponseMessage groupQuitResponseMessage) throws Exception
    {
        try
        {
            if (groupQuitResponseMessage.isSuccess())
            {
                System.out.println("群聊退出成功");
            }
            else
            {
                //失败
                System.out.println("群聊退出失败！失败原因：" + groupQuitResponseMessage.getReason());
                Toolkit.getDefaultToolkit().beep();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            LockSupport.unpark(Client.getThread());
        }
    }
}
