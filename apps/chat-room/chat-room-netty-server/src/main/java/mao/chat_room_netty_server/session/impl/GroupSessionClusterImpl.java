package mao.chat_room_netty_server.session.impl;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.entity.ClusterGroup;
import mao.chat_room_netty_server.producer.GroupProducer;
import mao.chat_room_netty_server.service.RedisService;
import mao.chat_room_netty_server.session.Group;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.session.impl
 * Class(类名): GroupSessionClusterImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/3
 * Time(创建时间)： 13:54
 * Version(版本): 1.0
 * Description(描述)： 集群模式聊天组会话管理接口实现类
 */

@Slf4j
@Service
public class GroupSessionClusterImpl implements GroupSession
{

    private final Session session;

    private final RedisService redisService;

    private final String host;

    private final GroupProducer groupProducer;

    @Autowired
    public GroupSessionClusterImpl(@Value("${server.port}") String port,
                                   Session session,
                                   RedisService redisService,
                                   GroupProducer groupProducer) throws UnknownHostException
    {
        /*
         * 主机地址
         */
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        this.session = session;
        this.redisService = redisService;
        this.host = hostAddress + ":" + port;
        this.groupProducer = groupProducer;
    }


    /**
     * 本地组信息
     */
    private final Map<String, Group> groupMap = new ConcurrentHashMap<>();

    @Override
    public int getSize()
    {
        return groupMap.size();
    }

    @Override
    public int getTotalSize()
    {
        return 0;
    }

    @Override
    public boolean hasGroup(String name)
    {
        Group group = groupMap.get(name);
        if (group != null)
        {
            //本地存在
            return true;
        }
        //本地不存在
        //查询redis
        return redisService.hasGroup(name);
    }

    @Override
    public void unbind(String username)
    {
        //发送消息
        groupProducer.sendGroupUnbindMemberMessage(username);
        /*groupMap.forEach(new BiConsumer<String, Group>()
        {
            *//**
     * 遍历群聊
     *
     * @param s     群聊名称
     * @param group 群聊对象
     *//*
            @Override
            public void accept(String s, Group group)
            {
                Iterator<String> iterator = group.getMembers().iterator();
                while (iterator.hasNext())
                {
                    String next = iterator.next();
                    if (next.equals(username))
                    {
                        //移除
                        log.debug("移除群聊" + s + "的成员：" + username);
                        redisService.removeGroupMembers(s, username, host);
                        iterator.remove();
                        break;
                    }
                }
                if (group.getMembers().size() == 0)
                {
                    removeGroup(s);
                }
            }
        });*/
    }

    @Override
    public void unbindFromMQ(String username)
    {
        groupMap.forEach(new BiConsumer<String, Group>()
        {
            /**
             * 遍历群聊
             *
             * @param s     群聊名称
             * @param group 群聊对象
             */
            @Override
            public void accept(String s, Group group)
            {
                Iterator<String> iterator = group.getMembers().iterator();
                while (iterator.hasNext())
                {
                    String next = iterator.next();
                    if (next.equals(username))
                    {
                        //移除
                        log.debug("移除群聊" + s + "的成员：" + username);
                        redisService.removeGroupMembers(s, username, host);
                        iterator.remove();
                        break;
                    }
                }
                if (group.getMembers().size() == 0)
                {
                    removeGroup(s);
                }
            }
        });
    }

    @Override
    public Group createGroup(String name, Set<String> members)
    {
        log.debug("创建群聊：" + name + "，成员：" + members);
        Set<String> members1 = redisService.createGroup(name, members, host);
        Group group = new Group(name, members1);
        groupMap.putIfAbsent(name, group);
        return group;
    }

    @Override
    public Group joinMember(String name, String member)
    {
        log.debug("成员：" + member + ",加入群聊：" + name);
        //得到群聊地址
        String host = redisService.getGroupAddress(name);
        if (host == null)
        {
            //群聊不存在
            return null;
        }
        //群聊存在
        //向本地写
        groupMap.computeIfPresent(name, new BiFunction<String, Group, Group>()
        {
            @Override
            public Group apply(String s, Group group)
            {
                //添加
                group.getMembers().add(member);
                return group;
            }
        });
        //向redis里写
        redisService.joinGroup(name, member, host);
        return new Group(name, null);
    }

    @Override
    public Group removeMember(String name, String member)
    {
        log.debug("成员：" + member + ",退出群聊：" + name);
        return groupMap.computeIfPresent(name, new BiFunction<String, Group, Group>()
        {
            @Override
            public Group apply(String s, Group group)
            {
                //移除群成员
                group.getMembers().remove(member);
                return group;
            }
        });
    }

    @Override
    public Group removeGroup(String name)
    {
        log.debug("移除群聊：" + name);
        return groupMap.remove(name);
    }

    @Override
    public Set<String> getMembers(String name)
    {
        log.debug("得到群聊：" + name + " 的所有群成员");
        Set<String> members = redisService.getMembers(name);
        log.debug("群成员：" + members);
        return members;
    }

    @Override
    public List<Channel> getMembersChannel(String name)
    {
        return getMembers(name).stream()
                .map(session::getChannel)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public ClusterGroup getMembersAndHost(String name)
    {
        return null;
    }
}
