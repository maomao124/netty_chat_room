package mao.chat_room_netty_server.contoller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.message.ChatRequestMessage;
import mao.chat_room_common.message.GroupChatResponseMessage;
import mao.chat_room_common.message.GroupCreateResponseMessage;
import mao.chat_room_netty_server.service.NettyService;
import mao.chat_room_server_api.config.ServerConfig;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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


    /**
     * 发送群聊创建消息
     *
     * @param groupCreateResponseMessages 群聊创建响应消息集合
     * @return {@link R}<{@link Boolean}>
     */
    @ApiOperation("发送群聊创建消息")
    @PostMapping("/sendGroupCreateMessage")
    public R<Boolean> sendGroupCreateMessage(@RequestBody List<GroupCreateResponseMessage> groupCreateResponseMessages)
    {
        return nettyService.sendGroupCreateMessage(groupCreateResponseMessages);
    }

    /**
     * 发送群聊聊天消息
     *
     * @param map {@link Map}<{@link String}, {@link GroupChatResponseMessage}>
     *            key为用户名，value为为GroupChatResponseMessage
     * @return {@link R}<{@link Boolean}>
     */
    @ApiOperation("发送群聊聊天消息")
    @PostMapping("/sendGroupChatMessage")
    public R<Boolean> sendGroupChatMessage(@RequestBody Map<String, GroupChatResponseMessage> map)
    {
        return nettyService.sendGroupChatMessage(map);
    }

    /**
     * 成员加入本地群聊
     *
     * @param name   群聊名字
     * @param member 群聊成员
     * @return {@link R}<{@link Boolean}>
     */
    @ApiOperation("成员加入本地群聊")
    @PostMapping("/joinMember")
    public R<Boolean> joinMember(@RequestParam String name, @RequestParam String member)
    {
        return nettyService.joinMember(name,member);
    }
}
