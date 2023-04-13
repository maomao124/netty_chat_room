package mao.chat_room_manage.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.entity.Instance;
import mao.chat_room_manage.entity.OnlineUserCount;
import mao.chat_room_manage.service.NettyService;
import mao.chat_room_manage.service.ReBalanceService;
import mao.chat_room_server_api.constants.RedisConstants;
import mao.tools_redis_cache.entity.LockInfo;
import mao.tools_redis_cache.service.RedisLockService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service.impl
 * Class(类名): ReBalanceServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/13
 * Time(创建时间)： 15:46
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class ReBalanceServiceImpl implements ReBalanceService
{

    @Resource
    private RedisLockService redisLockService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private NettyService nettyService;

    @Resource
    private RestTemplate restTemplate;


    @Override
    public void reBalance(String host)
    {
        //加分布式锁
        log.debug("尝试获取分布式锁");
        String lockKey = RedisConstants.re_balance_lock_key;
        LockInfo lockInfo = null;
        try
        {
            lockInfo = redisLockService.lock(lockKey);
            log.debug("获取分布式锁成功");
            //获取当前时间
            long now = System.currentTimeMillis();
            String timeKey = RedisConstants.re_balance_time_key;
            //从redis上获取时间
            String timeString = stringRedisTemplate.opsForValue().get(timeKey);
            //判断是否有这个key
            if (timeString == null)
            {
                //没有
                timeString = "1";
            }
            //转换
            long time = Long.parseLong(timeString);
            log.debug("上次reBalance时间：" + time);
            log.debug("当前时间：" + now);
            //判断时间差是否小于120秒
            if (now - time < 120000)
            {
                //间隔小于120秒
                log.debug("不需要reBalance");
            }
            else
            {
                //间隔大于于120秒
                log.debug("需要reBalance");
                //得到各实例用户在线人数
                OnlineUserCount onlineUserCount = nettyService.getOnlineUserCount();
                //集群数量
                List<Instance> instanceList = onlineUserCount.getInstanceList();
                int size = instanceList.size();
                log.debug("集群数量：" + size);
                log.debug("总在线人数：" + onlineUserCount.getTotalCount());
                if (onlineUserCount.getTotalCount() < 150)
                {
                    log.debug("人数太少，暂时不需要reBalance");
                    return;
                }
                //平均每个实例分配的人数
                long avgCount = onlineUserCount.getTotalCount() / size;
                log.debug("平均每个实例分配的人数:" + avgCount);

                log.debug("分配前：" + instanceList);

                List<Instance> lowInstanceList = new ArrayList<>();
                List<Instance> highInstanceList = new ArrayList<>();
                List<Instance> resultInstanceList = new ArrayList<>();
                for (Instance instance : instanceList)
                {
                    if (instance.getCount() > avgCount)
                    {
                        highInstanceList.add(instance);
                    }
                    else if (instance.getCount() < avgCount)
                    {
                        lowInstanceList.add(instance);
                    }
                    else
                    {
                        resultInstanceList.add(instance);
                    }
                }

                log.debug("人数较多的实例列表：" + highInstanceList);
                log.debug("人数较少的实例列表：" + lowInstanceList);

                while (true)
                {
                    Instance highInstance = highInstanceList.get(0);
                    Instance lowInstance = lowInstanceList.get(0);
                    if ((highInstance.getCount() - avgCount) > (avgCount - lowInstance.getCount()))
                    {
                        log.debug("大于");
                        long to = avgCount - lowInstance.getCount();
                        log.debug("分配数量：" + to + "  ," + highInstance + " --> "
                                + lowInstance);

                        log.debug("low:  " + lowInstance.getCount() + "-->" + (lowInstance.getCount() + to));
                        log.debug("high:  " + highInstance.getCount() + "-->" + (highInstance.getCount() - to));

                        lowInstance.setCount(lowInstance.getCount() + to);
                        highInstance.setCount(highInstance.getCount() - to);

                        log.debug("发起请求：" + highInstance.getHost() + ", 数量：" + to);
                        //todo

                        //删除
                        lowInstanceList.remove(lowInstance);
                        resultInstanceList.add(lowInstance);
                    }
                    else if ((highInstance.getCount() - avgCount) < (avgCount - lowInstance.getCount()))
                    {
                        log.debug("小于");
                        long to = highInstance.getCount() - avgCount;
                        log.debug("分配数量：" + to + "  ," + highInstance + " --> "
                                + lowInstance);

                        log.debug("low:  " + lowInstance.getCount() + "-->" + (lowInstance.getCount() + to));
                        log.debug("high:  " + highInstance.getCount() + "-->" + (highInstance.getCount() - to));

                        lowInstance.setCount(lowInstance.getCount() + to);
                        highInstance.setCount(highInstance.getCount() - to);

                        log.debug("发起请求：" + highInstance.getHost() + ", 数量：" + to);
                        //todo

                        //删除
                        highInstanceList.remove(highInstance);
                        resultInstanceList.add(highInstance);
                    }
                    else
                    {
                        log.debug("等于");
                        long to = highInstance.getCount() - avgCount;
                        log.debug("分配数量：" + to + "  ," + highInstance + " --> "
                                + lowInstance);

                        log.debug("low:  " + lowInstance.getCount() + "-->" + (lowInstance.getCount() + to));
                        log.debug("high:  " + highInstance.getCount() + "-->" + (highInstance.getCount() - to));

                        lowInstance.setCount(lowInstance.getCount() + to);
                        highInstance.setCount(highInstance.getCount() - to);

                        log.debug("发起请求：" + highInstance.getHost() + ", 数量：" + to);
                        //todo

                        //删除
                        highInstanceList.remove(highInstance);
                        lowInstanceList.remove(lowInstance);
                        resultInstanceList.add(highInstance);
                        resultInstanceList.add(lowInstance);
                    }


                    if (highInstanceList.size() == 0 || lowInstanceList.size() == 0)
                    {
                        break;
                    }

                }
                resultInstanceList.addAll(highInstanceList);
                resultInstanceList.addAll(lowInstanceList);

                log.debug("分配结果：" + resultInstanceList);

                stringRedisTemplate.opsForValue().set(timeKey, String.valueOf(now));
            }
        }
        finally
        {
            log.debug("释放分布式锁");
            redisLockService.unlock(lockInfo);
        }
    }
}
