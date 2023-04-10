package mao.console_test_client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import mao.chat_room_common.message.RegisterResponseMessage;
import mao.console_test_client.StressTestClient;

import java.awt.*;
import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.handler
 * Class(类名): RegisterResponseMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 22:50
 * Version(版本): 1.0
 * Description(描述)： 用户注册响应消息处理器
 */
@ChannelHandler.Sharable
public class RegisterResponseMessageHandler extends SimpleChannelInboundHandler<RegisterResponseMessage>
{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RegisterResponseMessage registerResponseMessage)
            throws Exception
    {
        try
        {
            if (registerResponseMessage.isSuccess())
            {
                //登录成功
                System.out.println("注册成功！ 请登录");
            }
            else
            {
                //登录失败
                System.out.println("注册失败！失败原因：" + registerResponseMessage.getReason());
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
