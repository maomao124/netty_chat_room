package mao.chat_room_manage.feign;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.chat_room_manage.config.FeignRequestInterceptor;
import mao.chat_room_server_api.constants.ServerConstants;
import mao.chat_room_server_api.dto.UserDTO;
import mao.chat_room_server_api.entity.User;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.feign
 * Interface(接口名): UserFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/13
 * Time(创建时间)： 15:14
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@FeignClient(value = ServerConstants.CHAT_ROOM_NETTY_SERVER,
        path = "user",
        configuration = FeignRequestInterceptor.class)
public interface UserFeignClient
{
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
    String setUserStatus(@PathVariable String username, @PathVariable boolean status);


    /**
     * 通过用户名得到用户信息
     *
     * @param username 用户名
     * @return {@link R}<{@link UserDTO}>
     */
    @ApiOperation("通过用户名得到用户信息")
    @GetMapping("/{username}")
    String getUserByUsername(@PathVariable String username);

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
    String page(@RequestBody UserDTO param,
                @RequestParam int current,
                @RequestParam int size);
}
