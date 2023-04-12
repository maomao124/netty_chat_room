package mao.chat_room_manage.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.entity.OnlineUserCount;
import mao.chat_room_manage.service.NettyService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.controller
 * Class(类名): NettyController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/5
 * Time(创建时间)： 14:38
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Api(tags = "netty相关", value = "netty相关")
@RestController("/netty")
public class NettyController extends BaseController
{
    @Resource
    private NettyService nettyService;

    /**
     * 得到各实例以及总在线用户数量
     *
     * @return {@link R}
     */
    public R<OnlineUserCount> getOnlineUserCount()
    {
        return success(null);
    }
}
