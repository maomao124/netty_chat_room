package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.message
 * Class(类名): LoginResponseMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 14:59
 * Version(版本): 1.0
 * Description(描述)： 登录响应消息
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LoginResponseMessage extends AbstractResponseMessage
{
    private String username;

    @Override
    public int getMessageType()
    {
        return LoginResponseMessage;
    }

    public LoginResponseMessage()
    {
    }

    public LoginResponseMessage(boolean success, String reason)
    {
        super(success, reason);
    }

    /**
     * 成功
     *
     * @return {@link LoginResponseMessage}
     */
    public static LoginResponseMessage success()
    {
        return new LoginResponseMessage(true, null);
    }


    /**
     * 失败
     *
     * @return {@link LoginResponseMessage}
     */
    public static LoginResponseMessage fail()
    {
        return new LoginResponseMessage(false, "未知");
    }

    /**
     * 失败
     *
     * @param reason 原因
     * @return {@link LoginResponseMessage}
     */
    public static LoginResponseMessage fail(String reason)
    {
        return new LoginResponseMessage(false, reason);
    }
}
