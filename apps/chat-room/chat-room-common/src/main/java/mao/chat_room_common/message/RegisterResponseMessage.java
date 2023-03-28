package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.message
 * Class(类名): RegisterResponseMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 15:04
 * Version(版本): 1.0
 * Description(描述)： 注册响应消息
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RegisterResponseMessage extends AbstractResponseMessage
{

    @Override
    public int getMessageType()
    {
        return 0;
    }

    public RegisterResponseMessage()
    {
    }

    public RegisterResponseMessage(boolean success, String reason)
    {
        super(success, reason);
    }

    /**
     * 成功
     *
     * @return {@link RegisterResponseMessage}
     */
    public static RegisterResponseMessage success()
    {
        return new RegisterResponseMessage(true, null);
    }


    /**
     * 失败
     *
     * @return {@link RegisterResponseMessage}
     */
    public static RegisterResponseMessage fail()
    {
        return new RegisterResponseMessage(false, "未知");
    }

    /**
     * 失败
     *
     * @param reason 原因
     * @return {@link RegisterResponseMessage}
     */
    public static RegisterResponseMessage fail(String reason)
    {
        return new RegisterResponseMessage(false, reason);
    }
}
