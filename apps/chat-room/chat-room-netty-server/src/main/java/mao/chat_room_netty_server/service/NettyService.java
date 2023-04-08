package mao.chat_room_netty_server.service;

import mao.chat_room_common.message.ChatRequestMessage;
import mao.chat_room_common.message.GroupChatResponseMessage;
import mao.chat_room_common.message.GroupCreateResponseMessage;
import mao.tools_core.base.R;

import java.util.List;
import java.util.Map;

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

    /**
     * 发送群聊创建消息
     *
     * @param groupCreateResponseMessages 创建响应消息集合
     * @return {@link R}<{@link Boolean}>
     */
    R<Boolean> sendGroupCreateMessage(List<GroupCreateResponseMessage> groupCreateResponseMessages);

    /**
     * 发送群聊聊天消息
     *
     * @param map {@link Map}<{@link String}, {@link GroupChatResponseMessage}> key为用户名，value为为GroupChatResponseMessage
     * @return {@link R}<{@link Boolean}>
     */
    R<Boolean> sendGroupChatMessage(Map<String, GroupChatResponseMessage> map);


    /**
     * 成员加入本地群聊
     *
     * @param name   群聊名字
     * @param member 群聊成员
     * @return {@link R}<{@link Boolean}>
     */
    R<Boolean> joinMember(String name, String member);
}
