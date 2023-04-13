package mao.chat_room_netty_server.handler;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler
 * Class(类名): ServerDuplexHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/12
 * Time(创建时间)： 21:07
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class ServerDuplexHandler extends ChannelDuplexHandler
{
    /**
     * 触发特殊事件
     *
     * @param ctx ctx
     * @param evt evt
     * @throws Exception 异常
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception
    {
        IdleStateEvent event = (IdleStateEvent) evt;
        //触发了读空闲事件
        if (event.state() == IdleState.READER_IDLE)
        {
            log.debug(ctx.channel() + "触发了读空闲事件");
            ctx.channel().close();
        }
    }
}
