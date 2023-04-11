package mao.chat_room_manage.service;

import mao.chat_room_manage.entity.Statistics;

import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service
 * Interface(接口名): LoginStatisticsService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/11
 * Time(创建时间)： 14:33
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface LoginStatisticsService
{
    /**
     * 得到最近一个月用户每天登录的次数
     *
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    List<Statistics> getRecentMonthLoginDayCount();

    /**
     * 得到最近一年每个月用户登录的次数
     *
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    List<Statistics> getRecentYearLoginMonthCount();

    /**
     * 得到最近一个月用户每天登录的大致人数 （一个人可能登录多次，但是只记录一次）
     *
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    List<Statistics> getRecentMonthLoginDayUVCount();

    /**
     * 得到最近一年每个月用户登录的大致人数 （一个人可能登录多次，但是只记录一次）
     *
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    List<Statistics> getRecentYearLoginMonthUVCount();
}
