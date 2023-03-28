package mao.chat_room_netty_server.service;

import mao.chat_room_server_api.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.service
 * Class(测试类名): UserServiceTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 22:24
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class UserServiceTest
{
    @Autowired
    private UserService userService;

    @Test
    void testQuery()
    {
        List<User> userList = userService.list();
        System.out.println(userList);
    }
}
