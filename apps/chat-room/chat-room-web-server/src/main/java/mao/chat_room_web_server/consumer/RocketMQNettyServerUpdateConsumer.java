package mao.chat_room_web_server.consumer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_server_api.constants.RocketMQConstants;
import mao.chat_room_web_server.service.NettyService;
import org.apache.rocketmq.spring.annotation.MessageModel;
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
 * <p>
 * RocketMQMessageListener注解参数说明：
 * <p>
 * - consumerGroup：消费者订阅组，它是必需的，并且必须是唯一的
 * - topic：主题名字，生产发送的主题名
 * - consumeMode：消费模式，可选择并发或有序接收消息；默认CONCURRENTLY同时接收异步传递的消息
 * - messageModel：消息模式，默认CLUSTERING集群消费；如果希望所有订阅者都接收消息，可以设置广播BROADCASTING
 * - consumeThreadMax：消费者最大线程数，默认64
 * - consumeTimeout：消息阻塞最长时间，默认15分钟
 * - nameServer：服务器地址，默认读取配置文件地址，可以单独为消费者设置指定位置
 * - selectorExpression：消费指定的Tag标签的业务消息
 */

@Slf4j
@Getter
@Component
@RocketMQMessageListener(consumerGroup = RocketMQConstants.GROUP,
        topic = RocketMQConstants.NETTY_SERVER_UPDATE_MESSAGE_TOPIC,
        messageModel = MessageModel.BROADCASTING)
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
