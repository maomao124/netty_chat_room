package mao.chat_room_web_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_server_api.config.DefaultRPCGlobalExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_web_server.config
 * Class(类名): ExceptionConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 14:26
 * Version(版本): 1.0
 * Description(描述)： 全局异常处理
 */

@Slf4j
@Configuration
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
public class ExceptionConfig extends DefaultRPCGlobalExceptionHandler
{
    @PostConstruct
    public void init()
    {
        log.info("初始化 ExceptionConfig");
    }
}
