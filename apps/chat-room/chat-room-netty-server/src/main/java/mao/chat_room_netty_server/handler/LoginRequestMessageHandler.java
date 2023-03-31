package mao.chat_room_netty_server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.GroupChatResponseMessage;
import mao.chat_room_common.message.LoginRequestMessage;
import mao.chat_room_common.message.LoginResponseMessage;
import mao.chat_room_netty_server.service.UserService;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import mao.chat_room_server_api.entity.User;
import mao.tools_core.exception.BizException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler
 * Class(类名): LoginRequestMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 14:59
 * Version(版本): 1.0
 * Description(描述)： 用户登录请求入栈消息处理器
 */

@Slf4j
@Service
@ChannelHandler.Sharable
public class LoginRequestMessageHandler extends SimpleChannelInboundHandler<LoginRequestMessage>
{

    @Resource
    private UserService userService;

    @Resource
    private Session session;

    @Resource
    private GroupSession groupSession;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestMessage loginRequestMessage) throws Exception
    {
        String username = loginRequestMessage.getUsername();
        String password = loginRequestMessage.getPassword();

        //检查登录状态
        if (session.isLogin(username))
        {
            //已登录
            ctx.writeAndFlush(LoginResponseMessage.fail("禁止在多台设备上同时登录!")
                    .setSequenceId(loginRequestMessage.getSequenceId()));
            return;
        }
        try
        {
            User user = userService.login(username, password);
            //登录成功,绑定
            session.bind(ctx.channel(), username);
            //响应
            ctx.writeAndFlush(LoginResponseMessage.success()
                    .setUsername(username)
                    .setSequenceId(loginRequestMessage.getSequenceId()));
            log.debug("用户" + username + "登录成功");
        }
        catch (BizException e)
        {
            //得到异常消息
            String message = e.getMessage();
            //登录失败
            ctx.writeAndFlush(LoginResponseMessage.fail(message)
                    .setSequenceId(loginRequestMessage.getSequenceId()));
            log.debug("用户" + username + "登录失败");

        }
        catch (Exception e)
        {
            log.error("登录过程中服务器错误：", e);
            ctx.writeAndFlush(LoginResponseMessage.fail("服务器错误! 请稍后在试！")
                    .setSequenceId(loginRequestMessage.getSequenceId()));
        }
    }
}
