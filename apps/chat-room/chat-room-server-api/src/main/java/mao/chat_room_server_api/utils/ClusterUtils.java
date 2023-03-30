package mao.chat_room_server_api.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_server_api.utils
 * Class(类名): ClusterUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 13:57
 * Version(版本): 1.0
 * Description(描述)： 集群工具类,注册中心为 Nacos
 */

@Slf4j
@Component
public class ClusterUtils
{

    public static final String CHAT_ROOM_NETTY_SERVER = "chat-room-netty-server";
    public static final String CHAT_ROOM_WEB_SERVER = "chat-room-web-server";

    /**
     * 应用程序名称
     */
    @Value("${spring.application.name}")
    private String appName;

    /**
     * 注册中心客户端
     */
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 负载平衡器客户端
     */
    @Resource
    private LoadBalancerClient loadBalancerClient;

    /**
     * 得到本服务的所有实例
     *
     * @return {@link List}<{@link ServiceInstance}>
     */
    public List<ServiceInstance> getServiceInstances()
    {
        //得到本服务上所有实例列表
        return discoveryClient.getInstances(appName);
    }

    /**
     * 通过负载均衡方式得到本服务的一个实例
     *
     * @return {@link ServiceInstance}
     */
    public ServiceInstance getServiceInstance()
    {
        return loadBalancerClient.choose(appName);
    }


    /**
     * 得到某个服务的所有实例
     *
     * @param appName 应用程序名称
     * @return {@link List}<{@link ServiceInstance}>
     */
    public List<ServiceInstance> getServiceInstances(String appName)
    {
        //得到本服务上所有实例列表
        return discoveryClient.getInstances(appName);
    }

    /**
     * 通过负载均衡方式得到某个服务的一个实例
     *
     * @param appName 应用程序名称
     * @return {@link ServiceInstance}
     */
    public ServiceInstance getServiceInstance(String appName)
    {
        return loadBalancerClient.choose(appName);
    }


    @PostConstruct
    public void init()
    {
        log.info("应用程序名称：" + appName);
        log.info("初始化 ClusterUtils");
    }
}
