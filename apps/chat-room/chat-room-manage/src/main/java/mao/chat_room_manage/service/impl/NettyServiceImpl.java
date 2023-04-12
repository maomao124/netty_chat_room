package mao.chat_room_manage.service.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.entity.Instance;
import mao.chat_room_manage.entity.OnlineUserCount;
import mao.chat_room_manage.service.NettyService;
import mao.chat_room_server_api.constants.ServerConstants;
import mao.chat_room_server_api.constants.UrlConstants;
import mao.chat_room_server_api.utils.ClusterUtils;
import mao.tools_core.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service.impl
 * Class(类名): NettyServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/7
 * Time(创建时间)： 17:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class NettyServiceImpl implements NettyService
{

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ClusterUtils clusterUtils;


    private NettyService nettyService;

    /**
     * 拿到自己的代理对象
     *
     * @param nettyService NettyService
     */
    @Lazy
    @Autowired
    public void setNettyService(NettyService nettyService)
    {
        log.debug(nettyService.toString());
        this.nettyService = nettyService;
    }

    @SneakyThrows
    @Override
    public OnlineUserCount getOnlineUserCount()
    {
        //得到netty服务的实例
        List<ServiceInstance> serviceInstances = clusterUtils.
                getServiceInstances(ServerConstants.CHAT_ROOM_NETTY_SERVER);
        CountDownLatch countDownLatch = new CountDownLatch(serviceInstances.size());
        List<Instance> instanceList = new ArrayList<>();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        for (ServiceInstance serviceInstance : serviceInstances)
        {
            //发起请求和处理结果
            nettyService.requestAndHandler(countDownLatch, instanceList, atomicBoolean, serviceInstance);
        }

        //等待完成
        countDownLatch.await();
        log.debug("请求全部完成");
        //判断是否成功
        if (atomicBoolean.get())
        {
            log.debug("最终结果为成功");
            long totalCount = 0L;
            for (Instance instance : instanceList)
            {
                Long count = instance.getCount();
                totalCount = totalCount + count;
            }
            //返回
            return new OnlineUserCount()
                    .setInstanceList(instanceList)
                    .setTotalCount(totalCount);
        }
        else
        {
            //失败
            log.info("最终结果为失败，返回空");
            return new OnlineUserCount().setTotalCount(0L).setInstanceList(new ArrayList<>());
        }

    }

    @Async
    @Override
    @SuppressWarnings("all")
    public void requestAndHandler(CountDownLatch countDownLatch, List<Instance> instanceList, AtomicBoolean atomicBoolean, ServiceInstance serviceInstance)
    {
        String ip = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String host = ip + ":" + port;
        try
        {
            //构建url
            String url = UrlConstants.buildGetOnlineUserCountUrl(host);
            log.debug("正在发起请求：" + url);
            //发起请求
            R r = restTemplate.getForObject(url, R.class);
            if (r.getIsError())
            {
                //失败
                log.warn("发起请求结果为失败：" + r.getMsg());
                atomicBoolean.set(false);
            }
            else
            {
                //成功
                Long count = Long.parseLong(r.getData().toString());
                synchronized (instanceList)
                {
                    instanceList.add(new Instance().setHost(host).setCount(count));
                }
            }
        }
        catch (Exception e)
        {
            log.error("错误：" + e.getMessage());
            atomicBoolean.set(false);
        }
        finally
        {
            countDownLatch.countDown();
        }
    }

}
