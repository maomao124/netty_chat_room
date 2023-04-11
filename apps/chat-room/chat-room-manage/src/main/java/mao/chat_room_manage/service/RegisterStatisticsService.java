package mao.chat_room_manage.service;

import mao.chat_room_manage.entity.Statistics;

import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service
 * Interface(接口名): RegisterStatisticsService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/11
 * Time(创建时间)： 20:40
 * Version(版本): 1.0
 * Description(描述)： 注册统计
 */

public interface RegisterStatisticsService
{
    /**
     * 得到最近一个月用户每天注册的次数
     *
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    List<Statistics> getRecentMonthRegisterDayCount();

    /**
     * 得到最近一年每个月用户注册的次数
     *
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    List<Statistics> getRecentYearRegisterMonthCount();


    /**
     * 得到用户某些天用户注册的次数
     *
     * @param startYear  起始年
     * @param startMonth 起始月
     * @param startDay   起始天
     * @param endYear    结束年
     * @param endMonth   结束月
     * @param endDay     结束天
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    List<Statistics> getRegisterDayCountList(int startYear, int startMonth, int startDay,
                                          int endYear, int endMonth, int endDay);

    /**
     * 得到用户某些月用户注册的次数
     *
     * @param startYear  起始年
     * @param startMonth 起始月
     * @param endYear    结束年
     * @param endMonth   结束月
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    List<Statistics> getRegisterMonthCountList(int startYear, int startMonth,
                                            int endYear, int endMonth);
}
