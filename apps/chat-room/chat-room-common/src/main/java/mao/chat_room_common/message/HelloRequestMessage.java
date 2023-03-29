package mao.chat_room_common.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Project name(项目名称)：Netty_自定义协议
 * Package(包名): mao.message
 * Class(类名): HelloRequestMessage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/26
 * Time(创建时间)： 14:20
 * Version(版本): 1.0
 * Description(描述)： 打招呼的请求消息
 */


@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HelloRequestMessage extends Message
{
    /**
     * 打招呼的人的姓名
     */
    private String name;

    /**
     * 内容
     */
    private String body;

    @Override
    public int getMessageType()
    {
        return HelloRequestMessage;
    }
}
