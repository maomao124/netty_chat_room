package mao.console_client.handler;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import mao.chat_room_common.message.PingMessage;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.handler
 * Class(类名): DuplexHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/12
 * Time(创建时间)： 21:02
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class DuplexHandler extends ChannelDuplexHandler
{
    /**
     * 触发特殊事件
     *
     * @param ctx ChannelHandlerContext
     * @param evt 事件
     * @throws Exception 异常
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception
    {
        IdleStateEvent event = (IdleStateEvent) evt;
        //触发了写空闲事件
        if (event.state() == IdleState.WRITER_IDLE)
        {
            //发送心跳包
            ctx.writeAndFlush(new PingMessage()
                    .setRequestTime(System.currentTimeMillis())
                    .setSequenceId());
        }
    }
}
