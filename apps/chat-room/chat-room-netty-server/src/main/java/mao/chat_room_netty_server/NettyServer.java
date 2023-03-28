package mao.chat_room_netty_server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server
 * Class(类名): NettyServer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 21:18
 * Version(版本): 1.0
 * Description(描述)： netty服务器初始化
 */

@Slf4j
@Component
public class NettyServer implements CommandLineRunner
{

    @Override
    public void run(String... args) throws Exception
    {

    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 NettyServer");
    }
}
