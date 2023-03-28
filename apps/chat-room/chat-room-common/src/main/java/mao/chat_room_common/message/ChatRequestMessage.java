package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.message
 * Class(类名): ChatRequestMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 14:02
 * Version(版本): 1.0
 * Description(描述)： 单人聊天请求消息
 */


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChatRequestMessage extends Message
{

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息到哪里去（发给谁）
     */
    private String to;

    /**
     * 消息来自哪里（谁发的）
     */
    private String from;

    @Override
    public int getMessageType()
    {
        return 0;
    }
}
