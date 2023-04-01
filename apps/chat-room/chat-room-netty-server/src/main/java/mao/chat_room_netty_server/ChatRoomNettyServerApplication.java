package mao.chat_room_netty_server;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_server_api.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class ChatRoomNettyServerApplication
{

    /**
     * 服务启动类
     *
     * @param args 参数
     */
    @SneakyThrows
    public static void main(String[] args)
    {
        //获取开始时间
        long start = System.currentTimeMillis();
        //启动
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ChatRoomNettyServerApplication.class, args);
        //环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //获取应用名称
        String appName = environment.getProperty("spring.application.name");
        //获取端口号
        String port = environment.getProperty("server.port");
        //获取主机地址
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        //获取上下文
        String contextPath = environment.getProperty("server.servlet.context-path");
        //判断上下文
        if (contextPath == null || contextPath.length() == 0 || contextPath.equals("/"))
        {
            contextPath = "";
        }
        //启动完成后在控制台提示项目启动成功，并且输出当前服务对应的swagger接口文档访问地址
        //http://localhost:8080/doc.html
        log.info("应用{}启动成功!swagger地址：http://{}:{}{}/doc.html  或者：http://127.0.0.1:{}{}/doc.html",
                appName, hostAddress, port, contextPath, port, contextPath);
        log.info("数据库监控地址：http://{}:{}{}/druid  或者：http://127.0.0.1:{}{}/druid",
                hostAddress, port, contextPath, port, contextPath);
        log.info("启动耗时：" + (System.currentTimeMillis() - start) + "ms");
        ServerConfig serverConfig = applicationContext.getBean(ServerConfig.class);
        log.info("Netty服务器启动位于" + serverConfig.getServerPort() + "端口");
        log.info("序列化算法:" + serverConfig.getSerializerAlgorithm().toString());
    }
}
