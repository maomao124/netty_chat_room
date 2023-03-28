package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Project name(项目名称)：Netty_自定义协议
 * Package(包名): mao.message
 * Class(类名): AbstractResponseMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/26
 * Time(创建时间)： 14:12
 * Version(版本): 1.0
 * Description(描述)： 抽象响应消息
 */


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class AbstractResponseMessage extends Message
{
    /**
     * 是否是成功的消息
     */
    private boolean success;

    /**
     * 如果失败，失败的原因
     */
    private String reason;

    public AbstractResponseMessage()
    {
    }

    public AbstractResponseMessage(boolean success, String reason)
    {
        this.success = success;
        this.reason = reason;
    }
}
