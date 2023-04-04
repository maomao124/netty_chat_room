package mao.chat_room_netty_server.consumer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_server_api.constants.RocketMQConstants;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.consumer
 * Class(类名): GroupUnbindMemberMessageConsumer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/4
 * Time(创建时间)： 20:15
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Getter
@Component
@RocketMQMessageListener(consumerGroup = RocketMQConstants.GROUP,
        topic = RocketMQConstants.GROUP_UNBIND_MEMBER_TOPIC,
        messageModel = MessageModel.BROADCASTING)
public class GroupUnbindMemberMessageConsumer implements RocketMQListener<String>
{

    @Resource
    private GroupSession groupSession;

    @Override
    public void onMessage(String s)
    {
        log.debug("接收移除群聊成员消息：" + s);
        groupSession.unbindFromMQ(s);
    }
}
