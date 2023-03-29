package mao.chat_room_netty_server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.mapper.UserMapper;
import mao.chat_room_netty_server.service.PasswordEncoderService;
import mao.chat_room_netty_server.service.UserService;
import mao.chat_room_server_api.entity.User;
import mao.tools_core.exception.BizException;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.service.impl
 * Class(类名): UserServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 22:23
 * Version(版本): 1.0
 * Description(描述)： 用户服务实现类
 */

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{

    @Resource
    private PasswordEncoderService passwordEncoderService;

    @Override
    @Transactional
    public User login(String username, String password)
    {
        if (username == null || username.equals(""))
        {
            throw new BizException("用户名不能为空");
        }
        if (password == null || password.equals(""))
        {
            throw new BizException("密码不能为空");
        }
        //查询数据库
        User user = this.getOne(Wraps.<User>lbQ().eq(User::getUsername, username));
        if (user == null)
        {
            throw new BizException("用户名不存在");
        }
        //验证密码是否正确
        boolean verification = passwordEncoderService.verification(password, user.getPassword());
        if (!verification)
        {
            throw new BizException("密码错误");
        }
        //密码正确,判断启用状态
        if (!user.getStatus())
        {
            //未启用
            throw new BizException("该账号已被禁用");
        }
        //更新登录时间
        this.update(Wraps.<User>lbU()
                .eq(User::getUsername, username)
                .set(User::getLastLoginTime, LocalDateTime.now()));
        //密码设空并返回
        return user.setPassword(null);
    }

    @Override
    @Transactional
    public boolean register(String username, String password)
    {
        if (username == null || username.equals(""))
        {
            throw new BizException("用户名不能为空");
        }
        if (password == null || password.equals(""))
        {
            throw new BizException("密码不能为空");
        }
        //查询数据库
        User user = this.getOne(Wraps.<User>lbQ().eq(User::getUsername, username));
        //判断用户名是否存在
        if (user.getUsername().equals(username))
        {
            throw new BizException("该用户名\"" + username + "\"已被占用! 换一个用户名吧");
        }
        User user1 = new User()
                .setUsername(username)
                .setPassword(passwordEncoderService.encoder(password))
                .setStatus(true)
                .setRegisterTime(LocalDateTime.now());
        //插入
        return this.save(user1);
    }

    @Override
    @Transactional
    public boolean setUserStatus(String username, boolean status)
    {
        return this.update(Wraps.<User>lbU()
                .eq(User::getUsername, username)
                .set(User::getStatus, status));
    }
}
