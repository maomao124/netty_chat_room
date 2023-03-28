package mao.chat_room_common.protocol;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Project name(项目名称)：Netty_自定义协议
 * Package(包名): mao.protocol
 * Class(类名): SequenceIdGenerator
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/26
 * Time(创建时间)： 21:06
 * Version(版本): 1.0
 * Description(描述)： 序列 ID 生成器，内部采用CAS的方式累加
 */

public class SequenceIdGenerator
{
    /**
     * id
     */
    private static final AtomicInteger id = new AtomicInteger();

    public static int nextId()
    {
        return id.incrementAndGet();
    }
}
