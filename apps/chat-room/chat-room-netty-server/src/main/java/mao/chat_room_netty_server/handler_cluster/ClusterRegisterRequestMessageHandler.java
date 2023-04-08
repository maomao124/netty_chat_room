package mao.chat_room_netty_server.handler_cluster;

import io.netty.channel.ChannelHandler;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.handler.RegisterRequestMessageHandler;
import mao.chat_room_netty_server.service.RedisService;
import mao.chat_room_netty_server.service.UserService;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler_cluster
 * Class(类名): ClusterRegisterRequestMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/8
 * Time(创建时间)： 14:42
 * Version(版本): 1.0
 * Description(描述)： 集群用户注册请求入栈消息处理器
 */

@Slf4j
@Service
@ChannelHandler.Sharable
public class ClusterRegisterRequestMessageHandler extends RegisterRequestMessageHandler
{
    @Resource
    private UserService userService;

    @Resource
    private Session session;

    @Resource
    private GroupSession groupSession;

    @Resource
    private RedisService redisService;
}
