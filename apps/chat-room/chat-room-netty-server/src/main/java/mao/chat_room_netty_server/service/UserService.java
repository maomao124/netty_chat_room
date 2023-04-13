package mao.chat_room_netty_server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import mao.chat_room_server_api.dto.UserDTO;
import mao.chat_room_server_api.entity.User;
import mao.tools_core.base.R;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.service
 * Interface(接口名): UserService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 22:22
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public interface UserService extends IService<User>
{
    /**
     * 简单登录，不做验证码之类的
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link User} 会有Biz异常
     */
    User login(String username, String password);

    /**
     * 简单用户注册，不要求邮箱、手机号之类的了
     *
     * @param username 用户名
     * @param password 密码
     * @return boolean
     */
    boolean register(String username, String password);

    /**
     * 设置用户状态
     *
     * @param username 用户名
     * @param status   状态，false表示禁用，ture表示启用
     * @return boolean
     */
    boolean setUserStatus(String username, boolean status);

    /**
     * 通过用户名得到用户信息
     *
     * @param username 用户名
     * @return {@link UserDTO}
     */
    UserDTO getUserByUsername(String username);

    /**
     * 分页查询
     *
     * @param param 参数
     * @param page  分页查询对象
     * @return {@link IPage}<{@link UserDTO}>
     */
    IPage<UserDTO> page(IPage<User> page, UserDTO param);
}
