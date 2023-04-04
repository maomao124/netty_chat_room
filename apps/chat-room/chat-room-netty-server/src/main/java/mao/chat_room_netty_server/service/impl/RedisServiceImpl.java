package mao.chat_room_netty_server.service.impl;

import cn.hutool.core.collection.ConcurrentHashSet;
import io.netty.channel.Channel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.GroupCreateResponseMessage;
import mao.chat_room_common.message.Message;
import mao.chat_room_netty_server.service.RedisService;
import mao.chat_room_netty_server.session.Session;
import mao.chat_room_server_api.constants.RedisConstants;
import mao.chat_room_server_api.constants.UrlConstants;
import mao.tools_core.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.service.impl
 * Class(类名): RedisServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 15:12
 * Version(版本): 1.0
 * Description(描述)： redis服务实现类,将来多条命令的操作可以使用lua脚本或者管道解决来提高性能，这里有并发问题
 */

@Slf4j
@Service
public class RedisServiceImpl implements RedisService
{
    @Resource
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 会话，有循环依赖
     */
    private Session session;

    @Resource
    private RestTemplate restTemplate;

    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(200,
            400, 3L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(200));


    @Autowired
    public void setSession(Session session)
    {
        this.session = session;
    }

    @Override
    public void bindToRedis(String username, String host)
    {
        String key1 = RedisConstants.chat_user_key + username;
        String key2 = RedisConstants.chat_user_key + host;
        stringRedisTemplate.opsForValue().set(key1, host);
        stringRedisTemplate.opsForSet().add(key2, username);
    }


    @Override
    public boolean hasLogin(String username)
    {
        String key1 = RedisConstants.chat_user_key + username;
        String host = stringRedisTemplate.opsForValue().get(key1);
        if (host == null || host.equals(""))
        {
            return false;
        }
        return true;
    }

    @Override
    public void unbind(String username)
    {
        String key1 = RedisConstants.chat_user_key + username;
        String host = stringRedisTemplate.opsForValue().get(key1);
        String key2 = RedisConstants.chat_user_key + host;
        stringRedisTemplate.opsForSet().remove(key2, username);
        stringRedisTemplate.delete(key1);
    }

    @Override
    public String getUserHost(String username)
    {
        String key1 = RedisConstants.chat_user_key + username;
        return stringRedisTemplate.opsForValue().get(key1);
    }

    @Override
    public Set<String> getHostUser(String host)
    {
        String key2 = RedisConstants.chat_user_key + host;
        return stringRedisTemplate.opsForSet().members(key2);
    }

    @Override
    public boolean hasGroup(String name)
    {
        String key = RedisConstants.chat_group_key + name;
        return Boolean.TRUE.equals(stringRedisTemplate.hasKey(key));
    }

    @Override
    public boolean removeGroupMembers(String name, String username, String host)
    {
        String key = RedisConstants.chat_group_key + name;
        stringRedisTemplate.opsForHash().delete(key, username);
        //判断是否需要移除组
        if (stringRedisTemplate.opsForHash().size(key) <= 1)
        {
            removeGroup(name, host);
        }
        return true;
    }

    @Override
    public boolean removeGroup(String name, String host)
    {
        String key = RedisConstants.chat_group_key + name;
        String key2 = RedisConstants.chat_group_list_key + host;
        stringRedisTemplate.delete(key);
        stringRedisTemplate.opsForSet().remove(key2, name);
        return true;
    }

    @SneakyThrows
    @Override
    public Set<String> createGroup(String name, Set<String> members, String host)
    {
        String key = RedisConstants.chat_group_key + name;
        String key2 = RedisConstants.chat_group_list_key + host;
        stringRedisTemplate.opsForHash().put(key, "host", host);
        log.debug("创建组：" + members);
        //在线成员列表
        Set<String> members1 = new ConcurrentHashSet<>(members.size());
        //分桶,key为host，value为GroupCreateResponseMessage列表
        Map<String, List<GroupCreateResponseMessage>> map = new HashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(members.size());
        for (String username : members)
        {
            threadPoolExecutor.submit(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        String usernameKey = RedisConstants.chat_user_key + username;
                        String host = stringRedisTemplate.opsForValue().get(usernameKey);
                        //判断用户是否在线
                        if (host == null || host.equals(""))
                        {
                            //不在线
                            log.debug("用户" + username + "不在线");
                        }
                        else
                        {
                            //在线
                            stringRedisTemplate.opsForHash().put(key, username, host);
                            log.debug("用户" + username + "在线，位于：" + host);
                            members1.add(username);
                            //准备通知在线的成员
                            Channel channel = session.getChannel(username);
                            //判断该用户是否在本地
                            if (channel != null)
                            {
                                //在本地，直接通知
                                //通知
                                channel.writeAndFlush(new GroupCreateResponseMessage()
                                        .setSuccess(true)
                                        .setReason("您已被拉入群聊\"" + name + "\"!")
                                        .setSequenceId());
                            }
                            else
                            {
                                //不在本地，在其他实例上
                                map.computeIfAbsent(host, k -> new ArrayList<>());
                                //对host加本地进程锁，相当于锁的map的桶下标的表头
                                synchronized (host.intern())
                                {
                                    List<GroupCreateResponseMessage> list = map.get(host);
                                    //发送推送消息时群成员只有一个，就是自己
                                    Set<String> usernameSet = new HashSet<>();
                                    usernameSet.add(username);
                                    Message message = new GroupCreateResponseMessage()
                                            .setMembers(usernameSet)
                                            .setSuccess(true)
                                            .setReason("您已被拉入群聊\"" + name + "\"!")
                                            .setSequenceId();
                                    list.add((GroupCreateResponseMessage) message);
                                }
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        log.error("错误：", e);
                    }
                    finally
                    {
                        countDownLatch.countDown();
                    }
                }
            });
        }
        stringRedisTemplate.opsForSet().add(key2, name);
        //等待
        countDownLatch.await();
        log.debug("在线成员：" + members1);
        log.debug("分桶结果：" + map);
        //远程调用其他实例，通知在线的成员
        //判断是否需要发起远程调用
        if (map.size() > 0)
        {
            //大于0，需要发起远程调用
            log.debug("将发起远程调用");
            CountDownLatch finalCountDownLatch = new CountDownLatch(map.size());
            map.forEach(new BiConsumer<String, List<GroupCreateResponseMessage>>()
            {
                /**
                 * forEach
                 *
                 * @param host                        主机地址
                 * @param groupCreateResponseMessages GroupCreateResponseMessage列表
                 */
                @Override
                public void accept(String host, List<GroupCreateResponseMessage> groupCreateResponseMessages)
                {
                    threadPoolExecutor.submit(() ->
                    {

                        try
                        {
                            log.debug("正在同步的方式推送给" + host);
                            String url = UrlConstants.buildGroupCreateRequestMessageUrl(host);
                            R r = restTemplate.postForObject(url, groupCreateResponseMessages, R.class);
                            if (r.getIsError())
                            {
                                //失败
                                log.warn("推送给" + host + "时出现错误:" + r.getMsg());
                            }
                            else
                            {
                                //成功
                                log.debug("推送给" + host + "成功");
                            }
                        }
                        catch (Exception e)
                        {
                            log.error("推送给" + host + "时出现错误:", e);
                        }
                        finally
                        {
                            finalCountDownLatch.countDown();
                        }
                    });
                }
            });

            //等待
            finalCountDownLatch.await();
            log.debug("推送完成");
        }
        //返回在线列表
        return members1;
    }

    @Override
    public void registerCount()
    {
        //得到当前时间
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        //构建key
        String dayKey = RedisConstants.register_day_count_key + year + ":" + month + ":" + day;
        log.debug("registerCount dayKey:" + dayKey);
        String monthKey = RedisConstants.register_month_count_key + year + ":" + month;
        log.debug("registerCount monthKey:" + monthKey);
        //统计
        stringRedisTemplate.opsForValue().increment(dayKey);
        stringRedisTemplate.opsForValue().increment(monthKey);
    }

    @Override
    public void loginCount(String username)
    {
        //得到当前时间
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        //构建key
        String dayCountKey = RedisConstants.login_day_count_key + year + ":" + month + ":" + day;
        String dayUVKey = RedisConstants.login_day_uv_count_key + year + ":" + month + ":" + day;
        String monthCountKey = RedisConstants.login_month_count_key + year + ":" + month;
        String monthUVKey = RedisConstants.login_month_uv_count_key + year + ":" + month;
        log.debug("login dayCountKey:" + dayCountKey);
        log.debug("login dayUVKey:" + dayUVKey);
        log.debug("login monthCountKey:" + monthCountKey);
        log.debug("login monthUVKey:" + monthUVKey);
        //统计
        stringRedisTemplate.opsForValue().increment(dayCountKey);
        stringRedisTemplate.opsForValue().increment(monthCountKey);
        //uv统计
        stringRedisTemplate.opsForHyperLogLog().add(dayUVKey, username);
        stringRedisTemplate.opsForHyperLogLog().add(monthUVKey, username);
    }

    @Override
    public void unbindGroup(String host)
    {
        //查询当前实例上有哪些群聊
        String key = RedisConstants.chat_group_list_key + host;
        Set<String> members = stringRedisTemplate.opsForSet().members(key);
        log.debug("即将解绑群聊");
        log.debug("key--->" + key);
        if (members == null)
        {
            return;
        }
        for (String member : members)
        {
            log.debug("即将删除群聊：" + member);
            key = RedisConstants.chat_group_key + member;
            stringRedisTemplate.delete(key);
        }
        key = RedisConstants.chat_group_list_key + host;
        stringRedisTemplate.delete(key);
    }


}
