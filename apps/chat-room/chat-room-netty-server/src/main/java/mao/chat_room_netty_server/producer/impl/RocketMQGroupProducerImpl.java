package mao.chat_room_netty_server.producer.impl;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.producer.GroupProducer;
import mao.chat_room_server_api.constants.RocketMQConstants;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.producer.impl
 * Class(类名): RocketMQGroupProducerImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/4
 * Time(创建时间)： 20:20
 * Version(版本): 1.0
 * Description(描述)： 消息群聊相关的生产者实现类
 */

@Slf4j
@Component
public class RocketMQGroupProducerImpl implements GroupProducer
{
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendGroupUnbindMemberMessage(String username)
    {
        log.info("发送移除群聊成员消息:" + username);
        rocketMQTemplate.convertAndSend(RocketMQConstants.NETTY_SERVER_UPDATE_MESSAGE_TOPIC, username);
    }
}
