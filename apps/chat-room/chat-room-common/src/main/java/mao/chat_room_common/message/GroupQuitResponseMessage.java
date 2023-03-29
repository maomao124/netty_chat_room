package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.message
 * Class(类名): GroupQuitResponseMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 14:50
 * Version(版本): 1.0
 * Description(描述)： 群聊退出响应消息
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class GroupQuitResponseMessage extends AbstractResponseMessage
{

    @Override
    public int getMessageType()
    {
        return GroupQuitResponseMessage;
    }

    public GroupQuitResponseMessage()
    {

    }

    public GroupQuitResponseMessage(boolean success, String reason)
    {
        super(success, reason);
    }

    /**
     * 成功
     *
     * @return {@link GroupQuitResponseMessage}
     */
    public static GroupQuitResponseMessage success()
    {
        return new GroupQuitResponseMessage(true, null);
    }


    /**
     * 失败
     *
     * @return {@link GroupQuitResponseMessage}
     */
    public static GroupQuitResponseMessage fail()
    {
        return new GroupQuitResponseMessage(false, "未知");
    }

    /**
     * 失败
     *
     * @param reason 原因
     * @return {@link GroupQuitResponseMessage}
     */
    public static GroupQuitResponseMessage fail(String reason)
    {
        return new GroupQuitResponseMessage(false, reason);
    }

}
