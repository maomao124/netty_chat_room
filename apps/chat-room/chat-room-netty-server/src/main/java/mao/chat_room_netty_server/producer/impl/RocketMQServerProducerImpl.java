package mao.chat_room_netty_server.producer.impl;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.producer.ServerProducer;
import mao.chat_room_netty_server.service.RedisService;
import mao.chat_room_server_api.constants.RocketMQConstants;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import org.springframework.messaging.support.MessageBuilder;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.producer.impl
 * Class(类名): RocketMQServerProducerImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/2
 * Time(创建时间)： 13:43
 * Version(版本): 1.0
 * Description(描述)： rocketMQ 消息生产者
 */

@Slf4j
@Component
public class RocketMQServerProducerImpl implements ServerProducer
{

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    private final String host;

    @Autowired
    public RocketMQServerProducerImpl(@Value("${server.port}") String port)
            throws UnknownHostException
    {
        /*
         * 主机地址
         */
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        this.host = hostAddress + ":" + port;

    }

    @Override
    public void sendNettyServerUpdateMessage()
    {
        log.info("发送netty服务变动更新消息");
        rocketMQTemplate.convertAndSend(RocketMQConstants.NETTY_SERVER_UPDATE_MESSAGE_TOPIC, host);
    }

    @Override
    public void sendReBalanceMessage()
    {
        log.info("发送netty ReBalance消息");
        rocketMQTemplate.syncSend(RocketMQConstants.NETTY_SERVER_RE_BALANCE_TOPIC,
                MessageBuilder.withPayload(host).build(),
                5000 ,
                4);
    }
}
