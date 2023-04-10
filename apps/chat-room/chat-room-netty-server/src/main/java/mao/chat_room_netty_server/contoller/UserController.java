package mao.chat_room_netty_server.contoller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.service.UserService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.contoller
 * Class(类名): UserController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/10
 * Time(创建时间)： 23:57
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Api(tags = "用户相关", value = "用户相关")
@RestController
public class UserController extends BaseController
{
    @Resource
    private UserService userService;


    /**
     * 设置用户状态
     *
     * @param username 用户名
     * @param status   状态，false表示禁用，ture表示启用
     * @return boolean
     */
    @ApiOperation("设置用户状态")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "username", value = "用户名", dataType = "String", required = true),
                    @ApiImplicitParam(name = "status", value = "状态，false表示禁用，ture表示启用",
                            dataType = "boolean", required = true)
            }
    )
    @PutMapping("/setUserStatus/{username}/{status}")
    R<Boolean> setUserStatus(@PathVariable String username, @PathVariable boolean status)
    {
        return success(userService.setUserStatus(username, status));
    }
}
