package mao.chat_room_manage.service;

import mao.chat_room_manage.entity.Statistics;

import java.util.List;
import java.util.Map;

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

    /**
     * 得到某一天聊天发送的条数（一个人可能发送多次聊天）
     *
     * @param year  年
     * @param month 月
     * @param day   天
     * @return long 某一天聊天发送的条数
     */
    long getChatDayCount(int year, int month, int day);

    /**
     * 得到某一月聊天发送的条数（一个人可能发送多次聊天）
     *
     * @param year  年
     * @param month 月
     * @return long 某一月聊天发送的条数
     */
    long getChatMonthCount(int year, int month);

    /**
     * 得到某一天群聊聊天发送的条数
     *
     * @param year  年
     * @param month 月
     * @param day   天
     * @return long 某一天群聊聊天消息发送的条数
     */
    long getGroupChatDayCount(int year, int month, int day);

    /**
     * 得到某一月群聊聊天发送的条数
     *
     * @param year  年
     * @param month 月
     * @return long 某一月群聊聊天消息发送的条数
     */
    long getGroupChatMonthCount(int year, int month);

    /**
     * 得到某一天群聊创建的次数
     *
     * @param year  年
     * @param month 月
     * @param day   天
     * @return long 某一天群聊创建的次数
     */
    long getGroupCreateDayCount(int year, int month, int day);

    /**
     * 得到某一月群聊创建的次数
     *
     * @param year  年
     * @param month 月
     * @return long 某一月群聊创建的次数
     */
    long getGroupCreateMonthCount(int year, int month);

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
