package mao.tools_core.base.id;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.base.id
 * Class(测试类名): AbstractIdGenerateTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 13:06
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class AbstractIdGenerateTest
{
    @Test
    void test1()
    {
        System.out.println(Long.MAX_VALUE >>> 22);
    }

    @Test
    void test2()
    {
        System.out.println(new Date(1420041600210L));
    }
}