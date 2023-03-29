package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.message
 * Class(类名): ChatResponseMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 14:05
 * Version(版本): 1.0
 * Description(描述)： 单人聊天响应消息
 */


@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ChatResponseMessage extends AbstractResponseMessage
{

    /**
     * 消息来自哪里（谁发的）
     */
    private String from;

    /**
     * 消息内容
     */
    private String content;

    public ChatResponseMessage(String from, String content)
    {
        this.from = from;
        this.content = content;
    }

    public ChatResponseMessage(boolean success, String reason, String from, String content)
    {
        super(success, reason);
        this.from = from;
        this.content = content;
    }

    @Override
    public int getMessageType()
    {
        return ChatResponseMessage;
    }


    public static ChatResponseMessage success(String from, String content)
    {
        return new ChatResponseMessage(true, null, from, content);
    }


    /**
     * 失败
     *
     * @return {@link ChatResponseMessage}
     */
    public static ChatResponseMessage fail()
    {
        return new ChatResponseMessage(false, "未知", null, null);
    }

    /**
     * 失败
     *
     * @param reason 原因
     * @return {@link ChatResponseMessage}
     */
    public static ChatResponseMessage fail(String reason)
    {
        return new ChatResponseMessage(false, reason, null, null);
    }


    /**
     * 失败
     *
     * @param reason  原因
     * @param from    消息来自哪里（谁发的）
     * @param content 消息内容
     * @return {@link ChatResponseMessage}
     */
    public static ChatResponseMessage fail(String reason, String from, String content)
    {
        return new ChatResponseMessage(false, reason, from, content);
    }
}
