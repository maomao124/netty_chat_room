package mao.chat_room_manage.service;

import mao.chat_room_common.entity.Server;
import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service
 * Interface(接口名): ServerService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/6
 * Time(创建时间)： 13:48
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface ServerService
{
    /**
     * 得到netty服务列表
     *
     * @return {@link List}<{@link Server}>
     */
    List<ServiceInstance> getNettyServers();
}
