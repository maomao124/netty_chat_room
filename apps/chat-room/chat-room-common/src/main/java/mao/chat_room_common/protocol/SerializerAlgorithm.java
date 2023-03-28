package mao.chat_room_common.protocol;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：Netty_自定义协议
 * Package(包名): mao.protocol
 * Enum(枚举名): SerializerAlgorithm
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/26
 * Time(创建时间)： 21:12
 * Version(版本): 1.0
 * Description(描述)： 序列化算法，json采用fastjson
 */

public enum SerializerAlgorithm implements Serializer
{
    Java
            {
                @Override
                public <T> T deserialize(Class<T> clazz, byte[] bytes)
                {
                    try
                    {
                        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
                        return (T) objectInputStream.readObject();
                    }
                    catch (IOException | ClassNotFoundException e)
                    {
                        throw new RuntimeException("反序列化失败", e);
                    }
                }

                @Override
                public <T> byte[] serialize(T object)
                {
                    try
                    {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        objectOutputStream.writeObject(object);
                        return byteArrayOutputStream.toByteArray();
                    }
                    catch (IOException e)
                    {
                        throw new RuntimeException("序列化失败", e);
                    }
                }
            },

    Json
            {
                @Override
                public <T> T deserialize(Class<T> clazz, byte[] bytes)
                {
                    String json = new String(bytes, StandardCharsets.UTF_8);
                    return JSON.parseObject(json, clazz);
                }

                @Override
                public <T> byte[] serialize(T object)
                {
                    String jsonString = JSON.toJSONString(object);
                    return jsonString.getBytes(StandardCharsets.UTF_8);
                }
            }
}
