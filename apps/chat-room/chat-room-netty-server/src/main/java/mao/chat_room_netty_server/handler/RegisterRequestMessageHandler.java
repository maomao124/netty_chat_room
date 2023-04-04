package mao.chat_room_netty_server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.RegisterRequestMessage;
import mao.chat_room_common.message.RegisterResponseMessage;
import mao.chat_room_netty_server.service.RedisService;
import mao.chat_room_netty_server.service.UserService;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import mao.tools_core.exception.BizException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler
 * Class(类名): RegisterRequestMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 15:13
 * Version(版本): 1.0
 * Description(描述)： 用户注册请求入栈消息处理器
 */

@Slf4j
@Service
@ChannelHandler.Sharable
public class RegisterRequestMessageHandler extends SimpleChannelInboundHandler<RegisterRequestMessage>
{
    @Resource
    private UserService userService;

    @Resource
    private Session session;

    @Resource
    private GroupSession groupSession;

    @Resource
    private RedisService redisService;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                RegisterRequestMessage registerRequestMessage) throws Exception
    {
        String username = registerRequestMessage.getUsername();
        String password = registerRequestMessage.getPassword();
        try
        {
            boolean register = userService.register(username, password);
            if (register)
            {
                //注册成功
                //响应
                ctx.writeAndFlush(RegisterResponseMessage.success()
                        .setReason("注册成功！ 请登录")
                        .setSequenceId(registerRequestMessage.getSequenceId()));
                //统计
                redisService.registerCount();
            }
            else
            {
                //注册失败
                ctx.writeAndFlush(RegisterResponseMessage.fail("注册失败!")
                        .setSequenceId(registerRequestMessage.getSequenceId()));
            }
        }
        catch (BizException e)
        {
            //错误消息
            String message = e.getMessage();
            //注册失败
            ctx.writeAndFlush(RegisterResponseMessage.fail(message)
                    .setSequenceId(registerRequestMessage.getSequenceId()));
        }
        catch (Exception e)
        {
            log.error("服务器错误：", e);
            ctx.writeAndFlush(RegisterResponseMessage.fail("服务器错误! 请稍后在试！")
                    .setSequenceId(registerRequestMessage.getSequenceId()));
        }
    }
}
