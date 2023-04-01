package mao.chat_room_netty_server.service;

import mao.chat_room_common.message.ChatRequestMessage;
import mao.tools_core.base.R;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.service
 * Interface(接口名): NettyService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 16:57
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface NettyService
{
    /**
     * 聊天请求消息发送
     *
     * @param chatRequestMessage 聊天请求消息
     * @return {@link R}
     */
    R<Boolean> chatRequestMessageSend(ChatRequestMessage chatRequestMessage);
}
