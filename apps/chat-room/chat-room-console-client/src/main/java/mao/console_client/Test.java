package mao.console_client;

import mao.chat_room_client_api.config.ClientConfig;

import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 13:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args)
    {
        List<String> serverHostList = ClientConfig.getServerHostList();
        System.out.println(serverHostList);
    }
}
