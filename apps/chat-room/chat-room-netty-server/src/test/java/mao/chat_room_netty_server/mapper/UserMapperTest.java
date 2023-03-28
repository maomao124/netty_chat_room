package mao.chat_room_netty_server.mapper;

import mao.chat_room_server_api.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.mapper
 * Class(测试类名): UserMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 22:20
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class UserMapperTest
{
    @Autowired
    private UserMapper userMapper;

    @Test
    void testQuery()
    {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }
}
