package mao.chat_room_netty_server.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.interceptor
 * Class(类名): PasswordInterceptor
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 16:26
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@RefreshScope
@Component
public class PasswordInterceptor extends HandlerInterceptorAdapter
{
    @Value("${password}")
    private String password;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String password = request.getHeader("password");
        if (password == null)
        {
            response.setStatus(401);
            return false;
        }
        if (!password.equals(this.password))
        {
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
