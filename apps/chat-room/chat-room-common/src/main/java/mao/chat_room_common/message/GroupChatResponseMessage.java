package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.message
 * Class(类名): GroupChatResponseMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 14:14
 * Version(版本): 1.0
 * Description(描述)： 群聊响应消息
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class GroupChatResponseMessage extends AbstractResponseMessage
{

    /**
     * 谁发的消息
     */
    private String from;

    /**
     * 内容
     */
    private String content;

    /**
     * 群聊名称
     */
    private String groupName;

    public GroupChatResponseMessage(String from, String content, String groupName)
    {
        this.from = from;
        this.content = content;
        this.groupName = groupName;
    }

    public GroupChatResponseMessage(boolean success, String reason, String from, String content, String groupName)
    {
        super(success, reason);
        this.from = from;
        this.content = content;
        this.groupName = groupName;
    }

    @Override
    public int getMessageType()
    {
        return GroupChatResponseMessage;
    }


    /**
     * 成功
     *
     * @param from      谁发的消息
     * @param content   内容
     * @param groupName 组名称
     * @return {@link GroupChatResponseMessage}
     */
    public static GroupChatResponseMessage success(String from, String content, String groupName)
    {
        return new GroupChatResponseMessage(true, null, from, content, groupName);
    }


    public static GroupChatResponseMessage fail(String from, String content, String groupName)
    {
        return new GroupChatResponseMessage(false, "未知", from, content, groupName);
    }

    /**
     * 失败
     *
     * @param reason    原因
     * @param from      谁发的消息
     * @param content   内容
     * @param groupName 组名称
     * @return {@link GroupChatResponseMessage}
     */
    public static GroupChatResponseMessage fail(String reason,String from, String content, String groupName)
    {
        return new GroupChatResponseMessage(false, "未知", from, content, groupName);
    }

    /**
     * 失败
     *
     * @param reason 原因
     * @return {@link GroupChatResponseMessage}
     */
    public static GroupChatResponseMessage fail(String reason)
    {
        return new GroupChatResponseMessage(false, reason, null, null, null);
    }

}
