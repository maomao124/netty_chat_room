package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.message
 * Class(类名): GroupMembersResponseMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 14:42
 * Version(版本): 1.0
 * Description(描述)： 得到组成员信息响应消息
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class GroupMembersResponseMessage extends AbstractResponseMessage
{
    /**
     * 组名称
     */
    private String groupName;

    /**
     * 成员列表
     */
    private Set<String> members;

    public GroupMembersResponseMessage(String groupName, Set<String> members)
    {
        this.groupName = groupName;
        this.members = members;
    }

    public GroupMembersResponseMessage(boolean success, String reason, String groupName, Set<String> members)
    {
        super(success, reason);
        this.groupName = groupName;
        this.members = members;
    }

    @Override
    public int getMessageType()
    {
        return 0;
    }

    /**
     * 成功
     *
     * @param groupName 组名称
     * @param members   成员
     * @return {@link GroupMembersResponseMessage}
     */
    public static GroupMembersResponseMessage success(String groupName, Set<String> members)
    {
        return new GroupMembersResponseMessage(true, null, groupName, members);
    }

    /**
     * 失败
     *
     * @param groupName 组名称
     * @param members   成员
     * @return {@link GroupMembersResponseMessage}
     */
    public static GroupMembersResponseMessage fail(String groupName, Set<String> members)
    {
        return new GroupMembersResponseMessage(false, "未知", groupName, members);
    }

    /**
     * 失败
     *
     * @param reason    原因
     * @param groupName 组名称
     * @param members   成员
     * @return {@link GroupMembersResponseMessage}
     */
    public static GroupMembersResponseMessage fail(String reason, String groupName, Set<String> members)
    {
        return new GroupMembersResponseMessage(false, reason, groupName, members);
    }

    /**
     * 失败
     *
     * @param reason    原因
     * @param groupName 组名称
     * @return {@link GroupMembersResponseMessage}
     */
    public static GroupMembersResponseMessage fail(String reason, String groupName)
    {
        return new GroupMembersResponseMessage(false, reason, groupName, null);
    }

    /**
     * 失败
     *
     * @param reason 原因
     * @return {@link GroupMembersResponseMessage}
     */
    public static GroupMembersResponseMessage fail(String reason)
    {
        return new GroupMembersResponseMessage(false, reason, null, null);
    }
}
