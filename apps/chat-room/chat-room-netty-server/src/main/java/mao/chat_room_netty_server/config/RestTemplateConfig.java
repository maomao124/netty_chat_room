package mao.chat_room_netty_server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.config
 * Class(类名): RestTemplateConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 16:00
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class RestTemplateConfig
{
    /**
     * RestTemplate,用于发送请求
     *
     * @return {@link RestTemplate}
     */
    public RestTemplate restTemplate()
    {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 RestTemplateConfig");
    }
}
