package mao.chat_room_manage.service;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service
 * Interface(接口名): StatisticsService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/6
 * Time(创建时间)： 13:59
 * Version(版本): 1.0
 * Description(描述)： 统计服务
 */

public interface StatisticsService
{
    /**
     * 得到某一天用户登录的总次数（一个人可能登录多次）
     *
     * @param year  年
     * @param month 月
     * @param day   天
     * @return int 某一天用户登录的总次数
     */
    int getLoginDayCount(int year, int month, int day);

    /**
     * 得到某月用户登录的总次数（一个人可能登录多次）
     *
     * @param year  年
     * @param month 月
     * @return int 某一月用户登录的总次数
     */
    int getLoginMonthCount(int year, int month);

    /**
     * 得到某一天用户登录的大致人数（一个人可能登录多次，但是只记录一次）
     *
     * @param year  年
     * @param month 月
     * @param day   天
     * @return int 某一天用户登录的大致人数
     */
    int getLoginDayUVCount(int year, int month, int day);

    /**
     * 得到某一月用户登录的大致人数（一个人可能登录多次，但是只记录一次）
     *
     * @param year  年
     * @param month 月
     * @return int 某一月用户登录的大致人数
     */
    int getLoginMonthUVCount(int year, int month);

    /**
     * 得到某一天用户注册的总次数（一个人可能登录多次）
     *
     * @param year  年
     * @param month 月
     * @param day   天
     * @return int  某一天用户注册的总次数
     */
    int getRegisterDayCount(int year, int month, int day);

    /**
     * 得到某一月用户注册的总次数（一个人可能登录多次）
     *
     * @param year  年
     * @param month 月
     * @return int 某一月用户注册的总次数
     */
    int getRegisterMonthCount(int year, int month);
}
