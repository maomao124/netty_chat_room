package mao.chat_room_netty_server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.service.UserService;
import mao.chat_room_server_api.dto.UserDTO;
import mao.chat_room_server_api.entity.User;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.controller
 * Class(类名): UserController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/10
 * Time(创建时间)： 23:57
 * Version(版本): 1.0
 * Description(描述)： 用户相关
 */

@Slf4j
@Api(tags = "用户相关", value = "用户相关")
@RequestMapping("/user")
@RestController
public class UserController extends BaseController
{
    @Resource
    private UserService userService;

    @Resource
    private DozerUtils dozerUtils;


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


    /**
     * 通过用户名得到用户信息
     *
     * @param username 用户名
     * @return {@link R}<{@link UserDTO}>
     */
    @GetMapping("/{username}")
    public R<UserDTO> getUserByUsername(@PathVariable String username)
    {
        return success(userService.getUserByUsername(username));
    }

    /**
     * 分页查询角色
     *
     * @param param   参数
     * @param current 当前页
     * @param size    页面大小
     * @return {@link R}<{@link IPage}<{@link UserDTO}>>
     */
    @ApiOperation(value = "分页查询角色", notes = "分页查询角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @PostMapping("/page")
    public R<IPage<UserDTO>> page(@RequestBody UserDTO param,
                                  @RequestParam int current,
                                  @RequestParam int size)
    {
        IPage<User> page = getPage();
        return success(userService.page(page, param));
    }
}
