package mao.chat_room_netty_server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler
 * Class(类名): QuitHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 14:40
 * Version(版本): 1.0
 * Description(描述)： 连接断开和异常入栈消息处理器
 */
@Slf4j
@Service
@ChannelHandler.Sharable
public class QuitHandler extends ChannelInboundHandlerAdapter
{

    @Resource
    private Session session;

    @Resource
    private GroupSession groupSession;

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception
    {
        log.debug(ctx.channel() + "断开");
        String username = session.getUsername(ctx.channel());
        groupSession.unbind(username);
        session.unbind(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        log.debug("{} 已经异常断开 异常是{}", ctx.channel(), cause.getMessage());
        String username = session.getUsername(ctx.channel());
        groupSession.unbind(username);
        session.unbind(ctx.channel());
    }
}
