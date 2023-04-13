package mao.chat_room_manage.consumer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.service.ReBalanceService;
import mao.chat_room_server_api.constants.RocketMQConstants;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.consumer
 * Class(类名): ReBalanceConsumer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/13
 * Time(创建时间)： 15:51
 * Version(版本): 1.0
 * Description(描述)： 消费者
 */

@Slf4j
@Getter
@Component
@RocketMQMessageListener(consumerGroup = RocketMQConstants.GROUP,
        topic = RocketMQConstants.NETTY_SERVER_RE_BALANCE_TOPIC,
        messageModel = MessageModel.CLUSTERING)
public class ReBalanceConsumer implements RocketMQListener<String>
{
    @Resource
    private ReBalanceService reBalanceService;

    @Override
    public void onMessage(String host)
    {
        log.debug("接收到ReBalance 消息");
        reBalanceService.reBalance(host);
    }
}
