package mao.chat_room_common.message;

import lombok.Data;
import mao.chat_room_common.protocol.SequenceIdGenerator;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：Netty_自定义协议
 * Package(包名): mao.message
 * Class(类名): Message
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/26
 * Time(创建时间)： 14:05
 * Version(版本): 1.0
 * Description(描述)： 协议父类消息
 */

@Data
public abstract class Message implements Serializable
{
    /**
     * 根据消息类型字节，获得对应的消息 class
     *
     * @param messageType 消息类型字节
     * @return 消息 class
     */
    public static Class<? extends Message> getMessageClass(int messageType)
    {
        return messageClasses.get(messageType);
    }

    /**
     * 序列id
     */
    private int sequenceId;

    /**
     * 设置序列id
     *
     * @param sequenceId 序列id
     */
    public void setSequenceId(int sequenceId)
    {
        this.sequenceId = sequenceId;
    }

    /**
     * 设置序列id
     */
    public void setSequenceId()
    {
        sequenceId = SequenceIdGenerator.nextId();
    }

    /**
     * 消息类型
     */
    private int messageType;

    /**
     * 得到消息类型
     *
     * @return int
     */
    public abstract int getMessageType();

    public static final int PingMessage = 1;
    public static final int PongMessage = 2;
    public static final int HelloRequestMessage = 3;
    public static final int HelloResponseMessage = 4;


    /**
     * 请求类型 byte 值
     */
    public static final int RPC_MESSAGE_TYPE_REQUEST = 101;

    /**
     * 响应类型 byte 值
     */
    public static final int RPC_MESSAGE_TYPE_RESPONSE = 102;

    /**
     * 消息类
     */
    private static final Map<Integer, Class<? extends Message>> messageClasses = new HashMap<>();

    static
    {
        messageClasses.put(PingMessage, PingMessage.class);
        messageClasses.put(PongMessage, PongMessage.class);
        messageClasses.put(HelloRequestMessage, HelloRequestMessage.class);
        messageClasses.put(HelloResponseMessage, HelloResponseMessage.class);
    }
}
