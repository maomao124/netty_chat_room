package mao.chat_room_netty_server.handler_cluster;

import io.netty.channel.ChannelHandler;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.handler.GroupMembersRequestMessageHandler;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.handler_cluster
 * Class(类名): ClusterGroupMembersRequestMessageHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/8
 * Time(创建时间)： 13:39
 * Version(版本): 1.0
 * Description(描述)： 得到群聊所有成员请求入栈消息处理器
 */

@Slf4j
@Service
@ChannelHandler.Sharable
public class ClusterGroupMembersRequestMessageHandler extends GroupMembersRequestMessageHandler
{
    @Resource
    private Session session;

    @Resource
    private GroupSession groupSession;

}
