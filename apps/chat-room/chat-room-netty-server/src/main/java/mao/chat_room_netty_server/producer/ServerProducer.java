package mao.chat_room_netty_server.producer;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.producer
 * Interface(接口名): ServerProducer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/2
 * Time(创建时间)： 13:42
 * Version(版本): 1.0
 * Description(描述)： 服务相关的消息生产者
 */

public interface ServerProducer
{
    /**
     * 发送netty服务变动更新消息
     */
    void sendNettyServerUpdateMessage();

    /**
     * 发送重新平衡信息
     * 当服务重启时，可能会造成负载不均衡的现象，大部分netty channel都跑到了老实例上
     * 此方法的作用是发送一条消息，重新分配netty的channel，让某些用户断开连接新的实例
     */
    void sendReBalanceMessage();
}
