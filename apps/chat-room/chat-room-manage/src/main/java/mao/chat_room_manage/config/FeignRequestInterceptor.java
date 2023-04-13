package mao.chat_room_manage.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.config
 * Class(类名): FeignRequestInterceptor
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/8
 * Time(创建时间)： 14:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class FeignRequestInterceptor implements RequestInterceptor
{
    @Value("${password}")
    private String password;

    @Override
    public void apply(RequestTemplate requestTemplate)
    {
        requestTemplate.header("password", password);
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 FeignRequestInterceptor");
    }
}
