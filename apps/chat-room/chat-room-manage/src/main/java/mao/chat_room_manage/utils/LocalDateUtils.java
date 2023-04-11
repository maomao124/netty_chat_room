package mao.chat_room_manage.utils;

import mao.tools_core.exception.BizException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.utils
 * Class(类名): LocalDateUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/11
 * Time(创建时间)： 14:49
 * Version(版本): 1.0
 * Description(描述)： 日期工具类
 */

public class LocalDateUtils
{
    /**
     * 得到两个日期的天数时间差
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return long 相差的天数
     */
    public static long getDayTimeDifference(LocalDate start, LocalDate end)
    {
        if (start.isAfter(end))
        {
            throw BizException.wrap("开始日期不能晚于结束日期");
        }
        long until = start.until(end, ChronoUnit.DAYS);
        if (until <= 0)
        {
            throw BizException.wrap("请选择两个具有日期差的日期");
        }
        return until;
    }

    /**
     * 得到两个日期的月数时间差
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return long 相差的月数
     */
    public static long getMonthTimeDifference(LocalDate start, LocalDate end)
    {
        if (start.isAfter(end))
        {
            throw BizException.wrap("开始日期不能晚于结束日期");
        }
        long until = start.until(end, ChronoUnit.MONTHS);
        if (until <= 0)
        {
            throw BizException.wrap("请选择两个具有日期差的日期");
        }
        return until;
    }

    /**
     * 处理年信息
     *
     * @param year 年
     */
    public static void handlerYear(int year)
    {
        if (year < 2000)
        {
            throw BizException.wrap("年份不能少于2000");
        }
        if (year > 3000)
        {
            throw BizException.wrap("年份不能大于3000");
        }
    }

    /**
     * 处理月信息
     *
     * @param month 月
     */
    public static void handlerMonth(int month)
    {
        if (month < 1 || month > 12)
        {
            throw BizException.wrap("输入的月份必须在1到12之间");
        }
    }

    /**
     * 处理天信息
     *
     * @param day 天
     */
    public static void handlerDay(int day)
    {
        if (day < 1 || day > 31)
        {
            throw BizException.wrap("输入的天数必须在1到31之间");
        }
    }
}
