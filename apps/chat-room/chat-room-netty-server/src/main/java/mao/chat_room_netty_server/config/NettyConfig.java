package mao.chat_room_netty_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.protocol.ProcotolFrameDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.config
 * Class(类名): NettyConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 15:30
 * Version(版本): 1.0
 * Description(描述)： netty 配置
 */

@Slf4j
@Configuration
public class NettyConfig
{
    /**
     * 协议帧解码器
     *
     * @return {@link ProcotolFrameDecoder}
     */
    @Bean
    public ProcotolFrameDecoder procotolFrameDecoder()
    {
        return new ProcotolFrameDecoder();
    }
}
