package mao.chat_room_common.message;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.message
 * Class(类名): GroupJoinResponseMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 14:36
 * Version(版本): 1.0
 * Description(描述)： 加入群聊响应消息
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class GroupJoinResponseMessage extends AbstractResponseMessage
{
    public GroupJoinResponseMessage()
    {
    }

    public GroupJoinResponseMessage(boolean success, String reason)
    {
        super(success, reason);
    }

    @Override
    public int getMessageType()
    {
        return GroupJoinResponseMessage;
    }

    /**
     * 成功
     *
     * @return {@link GroupJoinResponseMessage}
     */
    public static GroupJoinResponseMessage success()
    {
        return new GroupJoinResponseMessage(true, null);
    }

    /**
     * 失败
     *
     * @return {@link GroupJoinResponseMessage}
     */
    public static GroupJoinResponseMessage fail()
    {
        return new GroupJoinResponseMessage(false, "未知");
    }

    /**
     * 失败
     *
     * @param reason 原因
     * @return {@link GroupJoinResponseMessage}
     */
    public static GroupJoinResponseMessage fail(String reason)
    {
        return new GroupJoinResponseMessage(false, reason);
    }
}
