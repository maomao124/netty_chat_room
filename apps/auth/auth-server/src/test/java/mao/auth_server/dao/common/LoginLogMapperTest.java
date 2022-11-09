package mao.auth_server.dao.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.common
 * Class(测试类名): LoginLogMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 22:22
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class LoginLogMapperTest
{

    @Autowired
    private LoginLogMapper loginLogMapper;


    @Test
    void findTotalVisitCount()
    {
        System.out.println(loginLogMapper.findTotalVisitCount());
    }

    @Test
    void findTodayVisitCount()
    {
        loginLogMapper.findTodayVisitCount(LocalDate.now());
    }

    @Test
    void findTodayIp()
    {
        Long ip = loginLogMapper.findTodayIp(LocalDate.now());
        System.out.println(ip);
    }

    @Test
    void findLastTenDaysVisitCount()
    {

    }

    @Test
    void findByBrowser()
    {
        List<Map<String, Object>> byBrowser = loginLogMapper.findByBrowser();
        System.out.println(byBrowser);
    }

    @Test
    void findByOperatingSystem()
    {
        System.out.println(loginLogMapper.findByOperatingSystem());
    }
}