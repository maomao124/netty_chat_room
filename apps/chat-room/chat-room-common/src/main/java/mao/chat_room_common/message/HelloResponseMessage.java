package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import mao.chat_room_common.protocol.SequenceIdGenerator;

/**
 * Project name(项目名称)：Netty_自定义协议
 * Package(包名): mao.message
 * Class(类名): HelloResponseMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/26
 * Time(创建时间)： 14:23
 * Version(版本): 1.0
 * Description(描述)： 打招呼的响应消息
 */


@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HelloResponseMessage extends AbstractResponseMessage
{
    /**
     * 要响应的消息
     */
    private String body;

    public HelloResponseMessage(String body)
    {
        this.body = body;
        setSequenceId(SequenceIdGenerator.nextId());
    }

    public HelloResponseMessage(boolean success, String reason, String body)
    {
        super(success, reason);
        this.body = body;
        setSequenceId(SequenceIdGenerator.nextId());
    }

    public HelloResponseMessage()
    {
        setSequenceId(SequenceIdGenerator.nextId());
    }

    @Override
    public int getMessageType()
    {
        return HelloResponseMessage;
    }

    //这里写静态方法简化类的频繁创建

    /**
     * 成功
     *
     * @param body 消息内容
     * @return {@link HelloResponseMessage}
     */
    public static HelloResponseMessage success(String body)
    {
        return new HelloResponseMessage(true, null, body);
    }


    /**
     * 失败
     *
     * @return {@link HelloResponseMessage}
     */
    public static HelloResponseMessage fail()
    {
        return new HelloResponseMessage(false, "未知", null);
    }

    /**
     * 失败
     *
     * @param reason 原因
     * @return {@link HelloResponseMessage}
     */
    public static HelloResponseMessage fail(String reason)
    {
        return new HelloResponseMessage(false, reason, null);
    }

}
