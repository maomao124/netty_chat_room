package mao.chat_room_netty_server.producer;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.producer
 * Interface(接口名): GroupProducer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/4
 * Time(创建时间)： 20:19
 * Version(版本): 1.0
 * Description(描述)： 消息群聊相关的生产者
 */

public interface GroupProducer
{
    /**
     * 发送解开成员消息
     *
     * @param username 用户名
     */
    void sendGroupUnbindMemberMessage(String username);
}
