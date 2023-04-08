package mao.chat_room_netty_server.session.impl;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.entity.ClusterGroup;
import mao.chat_room_netty_server.producer.GroupProducer;
import mao.chat_room_netty_server.service.RedisService;
import mao.chat_room_netty_server.session.Group;
import mao.chat_room_netty_server.session.GroupSession;
import mao.chat_room_netty_server.session.Session;
import mao.chat_room_server_api.constants.UrlConstants;
import mao.tools_core.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
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

    private final RestTemplate restTemplate;

    @Autowired
    public GroupSessionClusterImpl(@Value("${server.port}") String port,
                                   Session session,
                                   RedisService redisService,
                                   GroupProducer groupProducer,
                                   RestTemplate restTemplate) throws UnknownHostException
    {
        /*
         * 主机地址
         */
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        this.session = session;
        this.redisService = redisService;
        this.host = hostAddress + ":" + port;
        this.groupProducer = groupProducer;
        this.restTemplate = restTemplate;
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

    /**
     * 得到本地组信息
     *
     * @return {@link Map}<{@link String}, {@link Group}>
     */
    public Map<String, Group> getGroupMap()
    {
        return groupMap;
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
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        //判断该群聊是否在本地
        if (this.host.equals(host))
        {
            //在本地
            //向本地写
            groupMap.computeIfPresent(name, new BiFunction<String, Group, Group>()
            {
                @Override
                public Group apply(String s, Group group)
                {
                    //添加
                    group.getMembers().add(member);
                    atomicBoolean.set(true);
                    return group;
                }
            });
        }
        else
        {
            //不在本地
            //往其他实例上写
            String url = UrlConstants.buildJoinMemberUrl(host, name, member);
            //远程调用
            log.debug("发起远程调用：" + url);
            R r = restTemplate.postForObject(url, null, R.class);
            if (r.getIsError())
            {
                atomicBoolean.set(false);
                log.warn("加入群聊时出现错误：" + r.getMsg());
            }
            else
            {
                atomicBoolean.set(true);
            }
        }
        //判断是否需要向redis里写
        if (atomicBoolean.get())
        {
            //向redis里写
            redisService.joinGroup(name, member, host);
            return new Group(name, null);
        }
        return null;
    }

    @Override
    public Group removeMember(String name, String member)
    {
        log.debug("成员：" + member + ",退出群聊：" + name);
        //得到群聊地址
        String host = redisService.getGroupAddress(name);
        if (host == null)
        {
            //群聊不存在
            return null;
        }
        //判断群聊是否在本地
        if (this.host.equals(host))
        {
            //在本地
            return groupMap.computeIfPresent(name, new BiFunction<String, Group, Group>()
            {
                @Override
                public Group apply(String s, Group group)
                {
                    //移除群成员
                    group.getMembers().remove(member);
                    //向redis里移除
                    redisService.removeGroupMembers(name, member, host);
                    log.debug("成员：" + member + ",退出群聊：" + name + " 本地退出成功");
                    return group;
                }
            });
        }
        else
        {
            //不在本地
            //构建url
            String url = UrlConstants.buildRemoveMemberUrl(host, name, member);
            log.debug("发起远程调用：" + url);
            //发起远程调用
            R r = restTemplate.postForObject(url, null, R.class);
            if (r.getIsError())
            {
                log.debug("成员：" + member + ",退出群聊：" + name + " 时发生错误：" + r.getMsg());
                return null;
            }
            else
            {
                return new Group(name, null);
            }
        }
    }

    @Override
    public Group removeGroup(String name)
    {
        log.debug("移除本地群聊：" + name);
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
        Map<Object, Object> membersAndHost = redisService.getMembersAndHost(name);
        if (membersAndHost == null || membersAndHost.size() == 0)
        {
            return null;
        }
        String host = membersAndHost.get("host").toString();
        ClusterGroup clusterGroup = new ClusterGroup();
        clusterGroup.setGroupHost(host);
        membersAndHost.remove("host");
        Map<String, String> groupMembersAndHost = new HashMap<>(membersAndHost.size());
        membersAndHost.forEach((key, value) ->
        {
            String keyString = key.toString();
            String valueString = membersAndHost.get(key).toString();
            groupMembersAndHost.put(keyString, valueString);
        });
        return clusterGroup.setGroupMembersAndHost(groupMembersAndHost);
    }
}
