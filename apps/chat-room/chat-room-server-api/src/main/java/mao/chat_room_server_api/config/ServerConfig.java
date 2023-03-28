package mao.chat_room_server_api.config;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.protocol.SerializerAlgorithm;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_server_api.config
 * Class(类名): ServerConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 13:11
 * Version(版本): 1.0
 * Description(描述)： 服务器配置
 */

@Slf4j
@Component
public class ServerConfig
{

    @Resource
    private ChatConfigurationProperties chatConfigurationProperties;

    /**
     * 得到服务器端口号
     *
     * @return int
     */
    public int getServerPort()
    {
        return chatConfigurationProperties.getPort();
    }

    /**
     * 得到服务器ip
     *
     * @return int
     */
    public String getServerIp()
    {
        return chatConfigurationProperties.getIp();
    }

    /**
     * 得到序列化器算法
     *
     * @return {@link SerializerAlgorithm}
     */
    public SerializerAlgorithm getSerializerAlgorithm()
    {
        String value = chatConfigurationProperties.getSerializer();
        if (value == null)
        {
            return SerializerAlgorithm.Java;
        }
        else
        {
            return SerializerAlgorithm.valueOf(value);
        }
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 ServerConfig");
    }
}
