package mao.chat_room_common.protocol;

/**
 * Project name(项目名称)：Netty_自定义协议
 * Package(包名): mao.protocol
 * Interface(接口名): Serializer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/26
 * Time(创建时间)： 21:10
 * Version(版本): 1.0
 * Description(描述)： 用于扩展序列化、反序列化算法
 */

public interface Serializer
{
    /**
     * 反序列化
     *
     * @param clazz clazz
     * @param bytes 字节数组
     * @return {@link T}
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);

    /**
     * 序列化
     *
     * @param object 对象
     * @return {@link byte[]}
     */
    <T> byte[] serialize(T object);

}
