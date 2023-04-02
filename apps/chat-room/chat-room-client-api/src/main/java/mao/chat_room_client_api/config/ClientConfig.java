package mao.chat_room_client_api.config;

import mao.chat_room_common.entity.Server;
import mao.chat_room_common.protocol.SerializerAlgorithm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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

    public static int getIntRandom(int min, int max)
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

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
     * @return String
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
     * @return String
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
     * 得到随机的服务器端ip和端口号
     *
     * @return String
     */
    public static String getServerHost()
    {
        List<String> serverHostList = getServerHostList();
        if (serverHostList.size() == 0)
        {
            throw new RuntimeException("请在配置文件中配置服务器列表");
        }
        int random = getIntRandom(0, serverHostList.size() - 1);
        return serverHostList.get(random);
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

    /**
     * 得到服务器映射地址
     *
     * @return {@link String}
     */
    public static String getServerAddressMapping()
    {
        String value = properties.getProperty("server.mapping");
        if (value == null)
        {
            return "/serverAddress";
        }
        else
        {
            return value;
        }
    }

    /**
     * 得到web服务器url
     *
     * @return {@link String}
     */
    public static String getServerUrl()
    {
        return "http://" + getServerIp() + ":" + getServerPort() + getServerAddressMapping();
    }
}
