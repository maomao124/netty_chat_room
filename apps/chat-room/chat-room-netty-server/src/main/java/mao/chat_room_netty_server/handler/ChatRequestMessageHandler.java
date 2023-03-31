package mao.chat_room_netty_server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.ChatRequestMessage;
import mao.chat_room_common.message.ChatResponseMessage;
import mao.chat_room_netty_server.session.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler
 * Class(类名): ChatRequestMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/29
 * Time(创建时间)： 22:24
 * Version(版本): 1.0
 * Description(描述)： 聊天请求入栈消息处理器
 */

@Slf4j
@Service //这里应该添加Service而不是Component
@ChannelHandler.Sharable
public class ChatRequestMessageHandler extends SimpleChannelInboundHandler<ChatRequestMessage>
{

    @Resource
    private Session session;

    /**
     * 通道读事件触发
     *
     * @param ctx                ctx
     * @param chatRequestMessage 聊天请求消息
     * @throws Exception 异常
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                ChatRequestMessage chatRequestMessage) throws Exception
    {
        //发给谁
        String to = chatRequestMessage.getTo();
        Channel channel = session.getChannel(to);
        if (to.equals(chatRequestMessage.getFrom()))
        {
            //自己发送给自己
            ctx.writeAndFlush(ChatResponseMessage.fail("不能发送给自己")
                    .setSequenceId(chatRequestMessage.getSequenceId()));
            return;
        }
        if (channel == null)
        {
            //为空，不在线或者不存在
            ctx.writeAndFlush(ChatResponseMessage.fail("对方用户\"" + to + "\"不存在或者不在线")
                    .setSequenceId(chatRequestMessage.getSequenceId()));
        }
        else
        {
            //在线
            log.debug(chatRequestMessage.getFrom() + "--->" + chatRequestMessage.getTo());
            //写入到对方客户端
            channel.writeAndFlush(ChatResponseMessage
                    .success(chatRequestMessage.getFrom(),
                            chatRequestMessage.getContent())
                    .setSequenceId(chatRequestMessage.getSequenceId()));
            //写入到自己客户端
            ctx.writeAndFlush(ChatResponseMessage
                    .success(chatRequestMessage.getFrom(), null)
                    .setSequenceId(chatRequestMessage.getSequenceId()));
        }
    }
}
