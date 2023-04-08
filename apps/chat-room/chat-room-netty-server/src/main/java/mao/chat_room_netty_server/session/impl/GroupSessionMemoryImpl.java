package mao.chat_room_netty_server.session.impl;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.entity.ClusterGroup;
import mao.chat_room_netty_server.session.Group;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.session
 * Class(类名): GroupSessionMemoryImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/29
 * Time(创建时间)： 21:16
 * Version(版本): 1.0
 * Description(描述)： 聊天组会话管理接口实现类
 */

@Slf4j
//@Service
public class GroupSessionMemoryImpl implements GroupSession
{

    private final Session session;

    @Autowired
    public GroupSessionMemoryImpl(Session session)
    {
        this.session = session;
    }

    private final Map<String, Group> groupMap = new ConcurrentHashMap<>();


    @Override
    public int getSize()
    {
        return groupMap.size();
    }

    @Override
    public int getTotalSize()
    {
        throw new UnsupportedOperationException("无法得到所有实例下的群聊数量总大小");
    }

    @Override
    public Map<String, Group> getGroupMap()
    {
        return groupMap;
    }

    @Override
    public boolean hasGroup(String name)
    {
        return groupMap.get(name) != null;
    }

    @Override
    public void unbind(String username)
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
    public void unbindFromMQ(String username)
    {
        log.warn("方法不支持");
    }

    @Override
    public Group createGroup(String name, Set<String> members)
    {
        log.debug("创建群聊：" + name + "，成员：" + members);
        Group group = new Group(name, members);
        return groupMap.putIfAbsent(name, group);
    }

    @Override
    public Group joinMember(String name, String member)
    {
        log.debug("成员：" + member + ",加入群聊：" + name);
        return groupMap.computeIfPresent(name, new BiFunction<String, Group, Group>()
        {
            @Override
            public Group apply(String s, Group group)
            {
                //添加
                group.getMembers().add(member);
                return group;
            }
        });
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
        Set<String> members = groupMap.get(name).getMembers();
        if (members == null)
        {
            removeGroup(name);
            return Group.EMPTY_GROUP.getMembers();
        }
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
        throw new UnsupportedOperationException("方法不支持");
    }
}
