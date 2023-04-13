package mao.chat_room_manage.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.entity.Instance;
import mao.chat_room_manage.entity.OnlineUserCount;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service.impl
 * Class(测试类名): ReBalanceServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/13
 * Time(创建时间)： 22:30
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Slf4j
class ReBalanceServiceImplTest
{

    @Test
    void reBalance()
    {
        Instance instance1 = new Instance().setHost("1").setCount(200L);
        Instance instance2 = new Instance().setHost("2").setCount(492L);
        Instance instance3 = new Instance().setHost("3").setCount(129L);
        Instance instance4 = new Instance().setHost("4").setCount(476L);

        List<Instance> list = new ArrayList<>();
        list.add(instance1);
        list.add(instance2);
        list.add(instance3);
        list.add(instance4);

        long count = 0L;
        for (Instance instance : list)
        {
            Long count1 = instance.getCount();
            count = count1 + count;
        }

        OnlineUserCount onlineUserCount = new OnlineUserCount();
        onlineUserCount.setTotalCount(count)
                .setInstanceList(list);

        //集群数量
        List<Instance> instanceList = onlineUserCount.getInstanceList();
        int size = instanceList.size();
        log.debug("集群数量：" + size);
        log.debug("总在线人数：" + onlineUserCount.getTotalCount());
        /*if (onlineUserCount.getTotalCount() < 150)
        {
            log.debug("人数太少，暂时不需要reBalance");
            return;
        }*/
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
    }
}
