package mao.chat_room_netty_server;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_server_api.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;

@Slf4j
@SpringBootApplication
public class ChatRoomNettyServerApplication
{

    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = SpringApplication.run(ChatRoomNettyServerApplication.class, args);
        ServerConfig serverConfig = context.getBean(ServerConfig.class);
        log.info("Netty服务器启动位于" + serverConfig.getServerPort() + "端口");
        log.info("序列化算法:" + serverConfig.getSerializerAlgorithm().toString());
    }

}
