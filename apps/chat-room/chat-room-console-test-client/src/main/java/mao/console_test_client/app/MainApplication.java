package mao.console_test_client.app;

import mao.chat_room_client_api.net.RestfulHTTP;
import mao.chat_room_client_api.net.SimpleRestfulHTTPImpl;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.app
 * Class(类名): MainApplication
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/31
 * Time(创建时间)： 15:28
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class MainApplication
{
    private static String loginUsername;

    private static final RestfulHTTP restfulHTTP = new SimpleRestfulHTTPImpl();

    static
    {
        restfulHTTP.setCharset("utf-8");
        restfulHTTP.setConnectTimeout(10000);
        restfulHTTP.setReadTimeout(30000);
    }

    /**
     * 得到登录用户名
     *
     * @return {@link String}
     */
    public static String getLoginUsername()
    {
        return loginUsername;
    }

    /**
     * 设置登录用户名
     *
     * @param loginUsername 登录用户名
     */
    public static void setLoginUsername(String loginUsername)
    {
        MainApplication.loginUsername = loginUsername;
    }

    /**
     * 得到RestfulHTTP
     *
     * @return {@link RestfulHTTP}
     */
    public static RestfulHTTP getRestfulHTTP()
    {
        return restfulHTTP;
    }
}
