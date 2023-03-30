package mao.chat_room_common.protocol;

import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * Project name(项目名称)：Netty_自定义协议
 * Package(包名): mao.protocol
 * Class(类名): ProcotolFrameDecoder
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/26
 * Time(创建时间)： 14:57
 * Version(版本): 1.0
 * Description(描述)： 协议解码器
 */

public class ProcotolFrameDecoder extends LengthFieldBasedFrameDecoder
{
    /**
     * 协议解码器，默认
     */
    public ProcotolFrameDecoder()
    {
        this(4096, 12, 4, 0, 0);
    }

    /**
     * 协议解码器，参数传递
     *
     * @param maxFrameLength      最大值框架长度
     * @param lengthFieldOffset   长度字段偏移量
     * @param lengthFieldLength   长度字段长度
     * @param lengthAdjustment    长度调整
     * @param initialBytesToStrip 最初字节地带
     */
    public ProcotolFrameDecoder(int maxFrameLength, int lengthFieldOffset,
                                int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip)
    {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
    }
}
