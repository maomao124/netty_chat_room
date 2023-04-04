package mao.chat_room_web_server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.entity.Server;
import mao.chat_room_server_api.constants.CacheConstants;
import mao.chat_room_server_api.constants.ServerConstants;
import mao.chat_room_server_api.constants.UrlConstants;
import mao.chat_room_server_api.utils.ClusterUtils;
import mao.chat_room_web_server.service.NettyService;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_web_server.service.impl
 * Class(类名): NettyServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 20:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class NettyServiceImpl implements NettyService
{

    @Resource
    private CacheChannel cacheChannel;

    @Resource
    private ClusterUtils clusterUtils;

    @Resource
    private RestTemplate restTemplate;

    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(150,
            150, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(100));


    /**
     * 得到int随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return int
     */
    public static int getIntRandom(int min, int max)
    {
        if (min > max)
        {
            min = max;
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    @SneakyThrows
    @Override
    public Server getNettyServerAddress()
    {
        //得到实例别表
        CacheObject cacheObject = cacheChannel.get(CacheConstants.chat_server_key, "1");
        //判断是否为空
        if (cacheObject == null || cacheObject.getValue() == null)
        {
            //空，需要加载
            List<ServiceInstance> serviceInstances = clusterUtils.getServiceInstances(ServerConstants.CHAT_ROOM_NETTY_SERVER);
            if (serviceInstances == null || serviceInstances.size() == 0)
            {
                throw BizException.wrap("无法获取聊天服务器地址！请稍后在试");
            }
            //不是空
            int size = serviceInstances.size();
            CountDownLatch countDownLatch = new CountDownLatch(size);
            List<Server> list = new ArrayList<>(size);
            log.debug("加载服务实例");
            AtomicBoolean isSuccess = new AtomicBoolean(true);
            for (ServiceInstance serviceInstance : serviceInstances)
            {
                threadPoolExecutor.submit(() ->
                {
                    try
                    {
                        String host = serviceInstance.getHost();
                        int port = serviceInstance.getPort();
                        String url = UrlConstants.buildGetPortUrl(
                                serviceInstance.getHost() + ":" + port);
                        R r = restTemplate.getForObject(url, R.class);
                        if (r.getIsError())
                        {
                            log.warn(r.getMsg());
                            isSuccess.set(false);
                        }
                        else
                        {
                            Integer nettyPort = Integer.valueOf(r.getData().toString());
                            Server server = new Server()
                                    .setIp(host)
                                    .setPort(nettyPort);
                            synchronized (list)
                            {
                                list.add(server);
                            }
                        }
                    }
                    finally
                    {
                        countDownLatch.countDown();
                    }

                });
            }
            countDownLatch.await();
            if (isSuccess.get())
            {
                //请求成功
                //判断是否有数据
                if (list.size() == 0)
                {
                    //无数据
                    throw BizException.wrap("netty服务集群暂时都不可用，请稍后再试");
                }
                String json = JSON.toJSONString(list);
                log.debug(json);
                cacheChannel.set(CacheConstants.chat_server_key, "1", json);
                return list.get(getIntRandom(0, list.size() - 1));
            }
            else
            {
                if (list.size() == 0)
                {
                    throw BizException.wrap("无法获取聊天服务器地址！请稍后在试");
                }
                else
                {
                    return list.get(getIntRandom(0, list.size() - 1));
                }
            }
        }
        else
        {
            //不为空
            String json = cacheObject.getValue().toString();
            List<Server> list = JSON.parseArray(json, Server.class);
            return list.get(getIntRandom(0, list.size() - 1));
        }
    }

    @Override
    public void removeCache()
    {
        cacheChannel.clear(CacheConstants.chat_server_key);
    }
}
