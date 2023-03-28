package mao.chat_room_netty_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_databases.datasource.BaseMybatisConfiguration;
import mao.tools_databases.properties.DatabaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.config
 * Class(类名): MybatisConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 22:12
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class MybatisConfig extends BaseMybatisConfiguration
{
    public MybatisConfig(@Autowired DatabaseProperties databaseProperties)
    {
        super(databaseProperties);
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 MybatisConfig");
    }
}
