package mao.chat_room_netty_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_common.config.BaseConfig;
import mao.tools_common.undertow.UndertowServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

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
public class WebConfig extends BaseConfig
{
    @PostConstruct
    public void init()
    {
        log.info("初始化 WebConfig");
    }

}
