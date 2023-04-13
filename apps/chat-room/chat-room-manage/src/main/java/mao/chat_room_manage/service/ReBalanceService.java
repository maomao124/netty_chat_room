package mao.chat_room_manage.service;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service
 * Interface(接口名): ReBalanceService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/13
 * Time(创建时间)： 15:45
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface ReBalanceService
{
    /**
     * 重新平衡
     *
     * @param host 实例的地址
     */
    void reBalance(String host);
}
