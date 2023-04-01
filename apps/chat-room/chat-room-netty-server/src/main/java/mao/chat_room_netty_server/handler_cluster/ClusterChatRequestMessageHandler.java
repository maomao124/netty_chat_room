package mao.chat_room_netty_server.handler_cluster;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.ChatRequestMessage;
import mao.chat_room_common.message.ChatResponseMessage;
import mao.chat_room_netty_server.handler.ChatRequestMessageHandler;
import mao.chat_room_netty_server.service.RedisService;
import mao.chat_room_netty_server.session.Session;
import mao.tools_core.base.R;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler_cluster
 * Class(类名): ClusterChatRequestMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 16:09
 * Version(版本): 1.0
 * Description(描述)： 聊天请求入栈消息处理器
 */

@Slf4j
@Service //这里应该添加Service而不是Component
@ChannelHandler.Sharable
public class ClusterChatRequestMessageHandler extends ChatRequestMessageHandler
{
    @Resource
    private Session session;

    @Resource
    private RedisService redisService;

    @Resource
    private RestTemplate restTemplate;

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
        //检查登录状态
        if (!session.isLogin(ctx.channel()))
        {
            //未登录
            ctx.writeAndFlush(ChatResponseMessage.fail("请登录")
                    .setSequenceId(chatRequestMessage.getSequenceId()));
            return;
        }

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
            //为空，本地不在线或者不存在
            //查询其他实例
            String host = redisService.getUserHost(to);
            if (host == null)
            {
                //其他实例都不在线
                ctx.writeAndFlush(ChatResponseMessage.fail("对方用户\"" + to + "\"不存在或者不在线")
                        .setSequenceId(chatRequestMessage.getSequenceId()));
                return;
            }
            //其他实例在线
            //发起请求
            //url
            String url = "http://" + host + "/send";
            R r = restTemplate.postForObject(url, chatRequestMessage, R.class);
            if (r.getIsError())
            {
                //错误
                ctx.writeAndFlush(ChatResponseMessage.fail("服务器错误")
                        .setSequenceId(chatRequestMessage.getSequenceId()));
            }
            else
            {
                //写入到自己客户端
                ctx.writeAndFlush(ChatResponseMessage
                        .success(chatRequestMessage.getFrom(), null)
                        .setSequenceId(chatRequestMessage.getSequenceId()));
            }

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
