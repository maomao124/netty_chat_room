package mao.chat_room_netty_server.contoller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.ChatRequestMessage;
import mao.chat_room_netty_server.service.NettyService;
import mao.chat_room_server_api.config.ServerConfig;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.contoller
 * Class(类名): NettyController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 16:41
 * Version(版本): 1.0
 * Description(描述)： netty消息接收controller
 */

@Slf4j
@Api(tags = "netty相关", value = "netty相关")
@RestController
public class NettyController extends BaseController
{

    @Resource
    private NettyService nettyService;

    @Resource
    private ServerConfig serverConfig;

    /**
     * 发送聊天消息
     *
     * @param chatRequestMessage 聊天请求消息
     * @return {@link R}<{@link Boolean}>
     */
    @ApiOperation("发送聊天消息")
    @PostMapping("/send")
    public R<Boolean> send(@RequestBody ChatRequestMessage chatRequestMessage)
    {
        return nettyService.chatRequestMessageSend(chatRequestMessage);
    }

    /**
     * 得到当前实例的netty的端口号
     *
     * @return {@link R}<{@link Integer}>
     */
    @ApiOperation("得到当前实例的netty的端口号")
    @GetMapping("/port")
    public R<Integer> getPort()
    {
        return success(serverConfig.getServerPort());
    }
}
