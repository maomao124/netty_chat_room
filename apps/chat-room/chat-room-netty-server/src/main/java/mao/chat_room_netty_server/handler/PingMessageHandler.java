package mao.chat_room_netty_server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.PingMessage;
import mao.chat_room_common.message.PongMessage;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler
 * Class(类名): PingMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 21:57
 * Version(版本): 1.0
 * Description(描述)： ping消息
 */

@Slf4j
@Service
@ChannelHandler.Sharable
public class PingMessageHandler extends SimpleChannelInboundHandler<PingMessage>
{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PingMessage pingMessage) throws Exception
    {
        ctx.writeAndFlush(new PongMessage()
                .setRequestTime(pingMessage.getRequestTime())
                .setSequenceId(pingMessage.getSequenceId()));
    }
}
