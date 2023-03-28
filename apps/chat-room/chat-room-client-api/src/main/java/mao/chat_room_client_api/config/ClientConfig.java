package mao.chat_room_client_api.config;

import mao.chat_room_common.protocol.SerializerAlgorithm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Project name(项目名称)：Netty_自定义协议
 * Package(包名): mao.config
 * Class(类名): ClientConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/26
 * Time(创建时间)： 21:18
 * Version(版本): 1.0
 * Description(描述)： 客户端配置类
 */

public class ClientConfig
{

    private static Properties properties;

    static
    {
        try (InputStream inputStream =
                     ClientConfig.class.getClassLoader().getResourceAsStream("config.properties"))
        {
            properties = new Properties();
            properties.load(inputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 得到服务器端口号
     *
     * @return int
     */
    public static int getServerPort()
    {
        String value = properties.getProperty("server.port");
        if (value == null)
        {
            return 8080;
        }
        else
        {
            return Integer.parseInt(value);
        }
    }

    /**
     * 得到服务器端ip
     *
     * @return int
     */
    public static String getServerIp()
    {
        String value = properties.getProperty("server.ip");
        if (value == null)
        {
            return "127.0.0.1";
        }
        else
        {
            return value;
        }
    }


    /**
     * 得到服务器端ip和端口号的列表
     *
     * @return int
     */
    public static List<String> getServerHostList()
    {
        List<String> hosts = new ArrayList<>();
        int i = 1;
        while (true)
        {
            try
            {
                String key = "server.host" + i;
                String value = properties.getProperty(key);
                if (value == null || value.equals(""))
                {
                    return hosts;
                }
                hosts.add(value);
                i++;
            }
            catch (Exception e)
            {
                return hosts;
            }
        }
    }

    /**
     * 得到序列化器算法
     *
     * @return {@link SerializerAlgorithm}
     */
    public static SerializerAlgorithm getSerializerAlgorithm()
    {
        String value = properties.getProperty("serializer.algorithm");
        if (value == null)
        {
            return SerializerAlgorithm.Java;
        }
        else
        {
            return SerializerAlgorithm.valueOf(value);
        }
    }
}
