package mao.chat_room_netty_server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
@RefreshScope
public class RestTemplateConfig
{
    /**
     * RestTemplate,用于发送请求
     *
     * @param password 调用密码
     * @return {@link RestTemplate}
     */
    @Bean
    public RestTemplate restTemplate(@Value("${password}") String password)
    {
        RestTemplate restTemplate = new RestTemplate(new OkHttp3ClientHttpRequestFactory());
        //设置通用的请求头
        HeaderRequestInterceptor myHeader = new HeaderRequestInterceptor(password, password);
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(myHeader);
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    /**
     * 拦截器类，为restTemplatep后续调用请求时携带请求头
     */
    public static class HeaderRequestInterceptor implements ClientHttpRequestInterceptor
    {

        private final String header;

        private final String value;

        public HeaderRequestInterceptor(String header, String value)
        {
            this.header = header;
            this.value = value;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                throws IOException
        {
            request.getHeaders().set(header, value);
            return execution.execute(request, body);
        }

    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 RestTemplateConfig");
    }
}
