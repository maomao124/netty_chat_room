package mao.console_client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import mao.chat_room_common.message.LoginResponseMessage;
import mao.chat_room_common.message.PongMessage;
import mao.console_client.Client;

import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.handler
 * Class(类名): LoginResponseMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 22:40
 * Version(版本): 1.0
 * Description(描述)： 用户登录响应消息处理器
 */

@ChannelHandler.Sharable
public class LoginResponseMessageHandler extends SimpleChannelInboundHandler<LoginResponseMessage>
{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponseMessage loginResponseMessage) throws Exception
    {
        try
        {
            if (loginResponseMessage.isSuccess())
            {
                //登录成功
                System.out.println("登录成功");
            }
            else
            {
                //登录失败
                System.out.println("登录失败！失败原因：" + loginResponseMessage.getReason());
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
