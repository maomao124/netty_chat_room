package mao.chat_room_manage.service;

import mao.chat_room_manage.entity.Statistics;

import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service
 * Interface(接口名): GroupCreateStatisticsService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/12
 * Time(创建时间)： 13:32
 * Version(版本): 1.0
 * Description(描述)： 群聊创建统计服务
 */

public interface GroupCreateStatisticsService
{
    /**
     * 得到最近一个月每天群聊创建的次数
     *
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    List<Statistics> getRecentMonthGroupCreateDayCount();

    /**
     * 得到最近一年每个月群聊创建的次数
     *
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    List<Statistics> getRecentYearGroupCreateMonthCount();


    /**
     * 得到用户某些天群聊创建的次数
     *
     * @param startYear  起始年
     * @param startMonth 起始月
     * @param startDay   起始天
     * @param endYear    结束年
     * @param endMonth   结束月
     * @param endDay     结束天
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    List<Statistics> getCreateDayGroupCountList(int startYear, int startMonth, int startDay,
                                                int endYear, int endMonth, int endDay);

    /**
     * 得到用户某些月群聊创建的次数
     *
     * @param startYear  起始年
     * @param startMonth 起始月
     * @param endYear    结束年
     * @param endMonth   结束月
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    List<Statistics> getCreateMonthGroupCountList(int startYear, int startMonth,
                                                  int endYear, int endMonth);
}
