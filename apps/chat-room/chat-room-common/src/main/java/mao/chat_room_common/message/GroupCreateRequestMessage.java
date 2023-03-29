package mao.chat_room_common.message;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.message
 * Class(类名): GroupCreateRequestMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 14:22
 * Version(版本): 1.0
 * Description(描述)： 群聊创建请求消息
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class GroupCreateRequestMessage extends Message
{

    /**
     * 组名称
     */
    private String groupName;

    /**
     * 群成员
     */
    private Set<String> members;

    @Override
    public int getMessageType()
    {
        return GroupCreateRequestMessage;
    }
}
