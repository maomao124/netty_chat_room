package mao.chat_room_manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.entity.Server;
import mao.chat_room_manage.service.ServerService;
import mao.chat_room_server_api.constants.ServerConstants;
import mao.chat_room_server_api.utils.ClusterUtils;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.controller
 * Class(类名): ServerController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/5
 * Time(创建时间)： 14:41
 * Version(版本): 1.0
 * Description(描述)： 服务实例相关
 */

@Slf4j
@Api(tags = "服务实例相关", value = "服务实例相关")
@RestController("/server")
public class ServerController extends BaseController
{

    @Resource
    private ServerService serverService;

    @GetMapping("/nettyServer")
    @ApiOperation("得到netty服务集群的消息-无缓存")
    public R<List<ServiceInstance>> getNettyServers()
    {
        return success(serverService.getNettyServers());
    }
}
