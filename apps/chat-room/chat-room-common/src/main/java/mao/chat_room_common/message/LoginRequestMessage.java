package mao.chat_room_common.message;

import lombok.*;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.message
 * Class(类名): LoginRequestMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 14:55
 * Version(版本): 1.0
 * Description(描述)： 登录请求消息
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class LoginRequestMessage extends Message
{

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    @Override
    public int getMessageType()
    {
        return 0;
    }
}
