package mao.chat_room_server_api.config;

import lombok.Data;
import mao.chat_room_common.protocol.SerializerAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_server_api.config
 * Class(类名): ChatConfigurationProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 13:07
 * Version(版本): 1.0
 * Description(描述)： 配置属性类
 */

@Data
@Component
@ConfigurationProperties(prefix = "chat")
public class ChatConfigurationProperties
{
    /**
     * 服务ip
     */
    private String ip = "127.0.0.1";

    /**
     * 服务端口
     */
    private int port = 8080;

    /**
     * 序列化算法
     */
    private String serializer = "Java";


    /**
     * 得到序列化器算法
     *
     * @return {@link String}
     */
    public SerializerAlgorithm getSerializerAlgorithm()
    {
        String value = serializer;
        if (value == null)
        {
            return SerializerAlgorithm.Java;
        }
        else
        {
            return SerializerAlgorithm.valueOf(value);
        }
    }

    /**
     * 得到序列化器算法
     *
     * @return {@link String}
     */
    public String getSerializer()
    {
        return serializer;
    }
}
