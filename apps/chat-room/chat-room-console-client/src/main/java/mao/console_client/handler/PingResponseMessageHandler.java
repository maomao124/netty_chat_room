package mao.console_client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import mao.chat_room_common.message.PongMessage;
import mao.console_client.Client;

import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.handler
 * Class(类名): PingResponseMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 22:31
 * Version(版本): 1.0
 * Description(描述)： ping响应消息处理器
 */

@ChannelHandler.Sharable
public class PingResponseMessageHandler extends SimpleChannelInboundHandler<PongMessage>
{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PongMessage pongMessage) throws Exception
    {
        try
        {
            long requestTime = pongMessage.getRequestTime();
            long end = System.currentTimeMillis();
            System.out.println("ping成功！延时：" + (end - requestTime + " 毫秒"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("释放锁：" + Client.getThread().getName());
            LockSupport.unpark(Client.getThread());
        }
    }
}
