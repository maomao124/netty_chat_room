package mao.auth_server.dao.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.auth
 * Class(测试类名): UserMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 21:58
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class UserMapperTest
{

    @Autowired
    private UserMapper userMapper;

    @Test
    void findUserByRoleId()
    {
    }

    @Test
    void incrPasswordErrorNumById()
    {
    }

    @Test
    void findPage()
    {
    }

    @Test
    void resetPassErrorNum()
    {
    }

    @Test
    void updateLastLoginTime()
    {
    }
}