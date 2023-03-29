package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Project name(项目名称)：Netty_自定义协议
 * Package(包名): mao.message
 * Class(类名): PingMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/26
 * Time(创建时间)： 14:17
 * Version(版本): 1.0
 * Description(描述)： ping消息
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class PingMessage extends Message
{
    /**
     * 时间
     */
    private long requestTime;

    @Override
    public int getMessageType()
    {
        return PingMessage;
    }
}
