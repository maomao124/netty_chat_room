package mao.chat_room_manage.service;

import mao.chat_room_manage.entity.Instance;
import mao.chat_room_manage.entity.OnlineUserCount;
import mao.tools_core.base.R;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service
 * Interface(接口名): NettyService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/7
 * Time(创建时间)： 17:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface NettyService
{
    /**
     * 得到各实例以及总在线用户数量
     *
     * @return {@link OnlineUserCount}
     */
    OnlineUserCount getOnlineUserCount();

    /**
     * 发起请求和处理结果
     *
     * @param countDownLatch  倒计时门闩
     * @param instanceList    实例列表
     * @param atomicBoolean   原子布尔
     * @param serviceInstance 服务实例
     */
    @Async
    void requestAndHandler(CountDownLatch countDownLatch, List<Instance> instanceList,
                           AtomicBoolean atomicBoolean, ServiceInstance serviceInstance);
}
