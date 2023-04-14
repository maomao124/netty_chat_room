package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.message
 * Class(类名): ReBalanceResponseMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/13
 * Time(创建时间)： 23:19
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReBalanceResponseMessage extends AbstractResponseMessage
{
    private String host;

    public ReBalanceResponseMessage(String host)
    {
        this.host = host;
    }

    public ReBalanceResponseMessage(boolean success, String reason, String host)
    {
        super(success, reason);
        this.host = host;
    }

    @Override
    public int getMessageType()
    {
        return ReBalanceResponseMessage;
    }

    /**
     * 成功
     *
     * @param host host
     * @return {@link ReBalanceResponseMessage}
     */
    public static ReBalanceResponseMessage success(String host)
    {
        return new ReBalanceResponseMessage(true, null, host);
    }
}
