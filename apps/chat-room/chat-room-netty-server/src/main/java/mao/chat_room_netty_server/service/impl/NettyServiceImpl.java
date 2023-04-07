package mao.chat_room_netty_server.service.impl;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.ChatRequestMessage;
import mao.chat_room_common.message.ChatResponseMessage;
import mao.chat_room_common.message.GroupChatResponseMessage;
import mao.chat_room_common.message.GroupCreateResponseMessage;
import mao.chat_room_netty_server.service.NettyService;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import mao.tools_core.base.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.service.impl
 * Class(类名): NettyServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 16:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class NettyServiceImpl implements NettyService
{

    @Resource
    private Session session;

    @Resource
    private GroupSession groupSession;

    @Override
    public R<Boolean> chatRequestMessageSend(ChatRequestMessage chatRequestMessage)
    {
        log.debug("远程发起的聊天发送请求");
        //发给谁
        String to = chatRequestMessage.getTo();
        Channel channel = session.getChannel(to);
        if (channel == null)
        {
            //为空，不在线或者不存在
            return R.fail("对方用户\"" + to + "\"不存在或者不在线");
        }
        else
        {
            //在线
            log.debug(chatRequestMessage.getFrom() + "--->" + chatRequestMessage.getTo());
            //写入到对方客户端
            channel.writeAndFlush(ChatResponseMessage
                    .success(chatRequestMessage.getFrom(),
                            chatRequestMessage.getContent())
                    .setSequenceId(chatRequestMessage.getSequenceId()));
            //返回成功
            return R.success();
        }
    }

    @Override
    public R<Boolean> sendGroupCreateMessage(List<GroupCreateResponseMessage> groupCreateResponseMessages)
    {
        for (GroupCreateResponseMessage groupCreateResponseMessage : groupCreateResponseMessages)
        {
            log.debug("发送群聊创建消息");
            //得到用户名
            String username = groupCreateResponseMessage.getMembers().iterator().next();
            Channel channel = session.getChannel(username);
            if (channel != null)
            {
                channel.writeAndFlush(groupCreateResponseMessage);
            }
            else
            {
                log.info("发送群聊创建消息时，用户名：" + username + "无法发送");
            }
        }
        return R.success();
    }

    @Override
    public R<Boolean> sendGroupChatMessage(Map<String, GroupChatResponseMessage> map)
    {
        log.debug("发送群聊消息");
        map.forEach(new BiConsumer<String, GroupChatResponseMessage>()
        {
            /**
             * 遍历
             *
             * @param username                 用户名
             * @param groupChatResponseMessage 群组聊天响应消息
             */
            @Override
            public void accept(String username, GroupChatResponseMessage groupChatResponseMessage)
            {
                //根据用户名获取channel
                Channel channel = session.getChannel(username);
                //判断是否为空
                if (channel != null)
                {
                    channel.writeAndFlush(groupChatResponseMessage);
                }
                else
                {
                    //不存在
                    log.info("发送群聊消息时，用户名：" + username + "无法发送");
                }
            }
        });
        return R.success();
    }
}
