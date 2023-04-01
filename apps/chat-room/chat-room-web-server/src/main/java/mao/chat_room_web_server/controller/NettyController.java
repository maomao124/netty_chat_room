package mao.chat_room_web_server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.entity.Server;
import mao.chat_room_server_api.constants.ServerConstants;
import mao.chat_room_server_api.constants.UrlConstants;
import mao.chat_room_server_api.utils.ClusterUtils;
import mao.chat_room_web_server.service.NettyService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_web_server.controller
 * Class(类名): NettyController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 19:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Api(tags = "netty相关", value = "netty相关")
@RestController
public class NettyController extends BaseController
{

    @Resource
    private NettyService nettyService;

    /**
     * 通过负载均衡方式得到netty服务的一个实例地址
     *
     * @return {@link R}<{@link Server}>
     */
    @ApiOperation("得到netty服务实例地址")
    @GetMapping("/serverAddress")
    public R<Server> getServerAddress()
    {
        Server server = nettyService.getNettyServerAddress();
        return success(server);
    }
}
