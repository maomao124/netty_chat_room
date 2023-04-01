package mao.chat_room_netty_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.interceptor.PasswordInterceptor;
import mao.tools_common.config.BaseConfig;
import mao.tools_common.undertow.UndertowServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.config
 * Class(类名): WebConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/31
 * Time(创建时间)： 22:51
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class WebConfig extends BaseConfig implements WebMvcConfigurer
{
    @Resource
    private PasswordInterceptor passwordInterceptor;

    /**
     * 注册 拦截器
     *
     * @param registry InterceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(passwordInterceptor)
                .addPathPatterns("/**")
                .order(0)
                .excludePathPatterns(getExcludeCommonPathPatterns());
        WebMvcConfigurer.super.addInterceptors(registry);
    }


    /**
     * auth-client 中的拦截器需要排除拦截的地址
     */
    protected String[] getExcludeCommonPathPatterns()
    {
        return new String[]{
                "/error",
                "/login",
                "/v2/api-docs",
                "/v2/api-docs-ext",
                "/swagger-resources/**",
                "/webjars/**",
                "/",
                "/csrf",
                "/META-INF/resources/**",
                "/resources/**",
                "/static/**",
                "/public/**",
                "classpath:/META-INF/resources/**",
                "classpath:/resources/**",
                "classpath:/static/**",
                "classpath:/public/**",
                "/cache/**",
                "/swagger-ui.html**",
                "/doc.html**"
        };
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 WebConfig");
    }

}
