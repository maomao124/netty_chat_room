package mao.chat_room_web_server.consumer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_server_api.constants.RocketMQConstants;
import mao.chat_room_web_server.service.NettyService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_web_server.consumer
 * Class(类名): RocketMQNettyServerUpdateConsumer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/2
 * Time(创建时间)： 13:57
 * Version(版本): 1.0
 * Description(描述)： 消息消费者
 */

@Slf4j
@Getter
@Component
@RocketMQMessageListener(consumerGroup = RocketMQConstants.GROUP, topic = RocketMQConstants.NETTY_SERVER_UPDATE_MESSAGE_TOPIC)
public class RocketMQNettyServerUpdateConsumer implements RocketMQListener<String>
{

    @Resource
    private NettyService nettyService;

    @Override
    public void onMessage(String s)
    {
        log.info("收到netty服务变动消息：" + s);
        log.debug("删除缓存");
        nettyService.removeCache();
    }
}
