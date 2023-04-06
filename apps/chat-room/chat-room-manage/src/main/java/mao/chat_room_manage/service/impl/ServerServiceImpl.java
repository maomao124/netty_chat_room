package mao.chat_room_manage.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.entity.Server;
import mao.chat_room_manage.service.ServerService;
import mao.chat_room_server_api.constants.ServerConstants;
import mao.chat_room_server_api.utils.ClusterUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service.impl
 * Class(类名): ServerServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/6
 * Time(创建时间)： 13:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class ServerServiceImpl implements ServerService
{

    @Resource
    private ClusterUtils clusterUtils;

    @Override
    public List<ServiceInstance> getNettyServers()
    {
        return clusterUtils.getServiceInstances(ServerConstants.CHAT_ROOM_NETTY_SERVER);
    }
}
