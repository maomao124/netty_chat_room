package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.message
 * Class(类名): GroupCreateResponseMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 14:25
 * Version(版本): 1.0
 * Description(描述)： 群聊创建响应消息
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class GroupCreateResponseMessage extends AbstractResponseMessage
{
    /**
     * 群成员
     */
    private Set<String> members;


    @Override
    public int getMessageType()
    {
        return GroupCreateResponseMessage;
    }

    public GroupCreateResponseMessage(Set<String> members)
    {
        this.members = members;
    }

    public GroupCreateResponseMessage(boolean success, String reason, Set<String> members)
    {
        super(success, reason);
        this.members = members;
    }

    /**
     * 成功
     *
     * @param members 成员
     * @return {@link GroupCreateResponseMessage}
     */
    public static GroupCreateResponseMessage success(Set<String> members)
    {
        return new GroupCreateResponseMessage(true, null, members);
    }

    /**
     * 失败
     *
     * @param reason 原因
     * @return {@link GroupCreateResponseMessage}
     */
    public static GroupCreateResponseMessage fail(String reason)
    {
        return new GroupCreateResponseMessage(false, reason, null);
    }

    /**
     * 失败
     *
     * @return {@link GroupCreateResponseMessage}
     */
    public static GroupCreateResponseMessage fail()
    {
        return new GroupCreateResponseMessage(false, "未知", null);
    }
}
