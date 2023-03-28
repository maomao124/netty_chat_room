package mao.chat_room_server_api.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.Message;
import mao.chat_room_common.protocol.MessageCodecSharable;
import mao.chat_room_server_api.config.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_server_api.protocol
 * Class(类名): ServerMessageCodecSharable
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 13:18
 * Version(版本): 1.0
 * Description(描述)： 服务端序列化与反序列化器
 */

@Slf4j
@Component
public class ServerMessageCodecSharable extends MessageCodecSharable
{

    @Resource
    private ServerConfig serverConfig;

    /**
     * 编码
     *
     * @param ctx     ctx
     * @param msg     Message对象
     * @param outList List<Object>
     * @throws Exception 异常
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> outList) throws Exception
    {
        ByteBuf out = ctx.alloc().buffer();
        //字节的魔数，用来在第一时间判定是否是无效数据包
        out.writeBytes(new byte[]{1, 2, 3, 4});
        //字节的版本，可以支持协议的升级
        out.writeByte(1);
        //字节的序列化方式 jdk 0 , json 1
        out.writeByte(serverConfig.getSerializerAlgorithm().ordinal());
        //字节的指令类型
        out.writeByte(msg.getMessageType());
        //4个字节，为了双工通信，提供异步能力
        out.writeInt(msg.getSequenceId());
        //无意义，对齐填充
        out.writeByte(0xff);
        //获取内容的字节数组
        byte[] bytes = serverConfig.getSerializerAlgorithm().serialize(msg);
        //写入长度消息
        out.writeInt(bytes.length);
        //写入内容消息
        out.writeBytes(bytes);
        outList.add(out);
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 ServerMessageCodecSharable");
    }
}
