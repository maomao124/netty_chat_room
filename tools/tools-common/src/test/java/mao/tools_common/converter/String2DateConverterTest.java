package mao.tools_common.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.converter
 * Class(测试类名): String2DateConverterTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 20:50
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class String2DateConverterTest
{

    @Test
    void convert()
    {
        System.out.println(new String2DateConverter().convert("2012/6/13"));
    }
}