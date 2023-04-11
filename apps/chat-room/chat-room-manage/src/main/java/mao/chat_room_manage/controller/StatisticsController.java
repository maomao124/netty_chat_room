package mao.chat_room_manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.service.StatisticsService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.controller
 * Class(类名): StatisticsController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/5
 * Time(创建时间)： 14:39
 * Version(版本): 1.0
 * Description(描述)： 统计
 */

@Slf4j
@Api(tags = "统计", value = "统计")
@RestController("/statistics")
public class StatisticsController extends BaseController
{

    @Resource
    private StatisticsService statisticsService;


    /**
     * 得到某一天用户登录的总次数（一个人可能登录多次）
     *
     * @param year  年
     * @param month 月
     * @param day   天
     * @return {@link R}<{@link Integer}> 某一天用户登录的总次数
     */
    @ApiOperation("得到某一天用户登录的总次数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", dataType = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", dataType = "int", required = true),
                    @ApiImplicitParam(name = "day", value = "日", dataType = "int", required = true)
            }
    )
    @GetMapping("/getLoginDayCount")
    public R<Integer> getLoginDayCount(@RequestParam int year,
                                       @RequestParam int month,
                                       @RequestParam int day)
    {
        return success(statisticsService.getLoginDayCount(year, month, day));
    }

    /**
     * 得到某月用户登录的总次数（一个人可能登录多次）
     *
     * @param year  年
     * @param month 月
     * @return {@link R}<{@link Integer}> 某一月用户登录的总次数
     */
    @ApiOperation("得到某月用户登录的总次数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", dataType = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", dataType = "int", required = true),
            }
    )
    @GetMapping("/getLoginMonthCount")
    public R<Integer> getLoginMonthCount(@RequestParam int year,
                                         @RequestParam int month)
    {
        return success(statisticsService.getLoginMonthCount(year, month));
    }

    /**
     * 得到某一天用户登录的大致人数（一个人可能登录多次，但是只记录一次）
     *
     * @param year  年
     * @param month 月
     * @param day   天
     * @return {@link R}<{@link Integer}> 某一天用户登录的大致人数
     */
    @ApiOperation("得到某一天用户登录的大致人数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", dataType = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", dataType = "int", required = true),
                    @ApiImplicitParam(name = "day", value = "日", dataType = "int", required = true)
            }
    )
    @GetMapping("/getLoginDayUVCount")
    public R<Integer> getLoginDayUVCount(@RequestParam int year,
                                         @RequestParam int month,
                                         @RequestParam int day)
    {
        return success(statisticsService.getLoginDayUVCount(year, month, day));
    }

    /**
     * 得到某一月用户登录的大致人数（一个人可能登录多次，但是只记录一次）
     *
     * @param year  年
     * @param month 月
     * @return {@link R}<{@link Integer}> 某一月用户登录的大致人数
     */
    @ApiOperation("得到某一月用户登录的大致人数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", dataType = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", dataType = "int", required = true),
            }
    )
    @GetMapping("/getLoginMonthUVCount")
    public R<Integer> getLoginMonthUVCount(@RequestParam int year,
                                           @RequestParam int month)
    {
        return success(statisticsService.getLoginMonthUVCount(year, month));
    }

    /**
     * 得到某一天用户注册的总次数（一个人可能登录多次）
     *
     * @param year  年
     * @param month 月
     * @param day   天
     * @return {@link R}<{@link Integer}>  某一天用户注册的总次数
     */
    @ApiOperation("得到某一天用户注册的总次数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", dataType = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", dataType = "int", required = true),
                    @ApiImplicitParam(name = "day", value = "日", dataType = "int", required = true)
            }
    )
    @GetMapping("/getRegisterDayCount")
    public R<Integer> getRegisterDayCount(@RequestParam int year,
                                          @RequestParam int month,
                                          @RequestParam int day)
    {
        return success(statisticsService.getRegisterDayCount(year, month, day));
    }

    /**
     * 得到某一月用户注册的总次数（一个人可能登录多次）
     *
     * @param year  年
     * @param month 月
     * @return int 某一月用户注册的总次数
     */
    @ApiOperation("得到某一月用户注册的总次数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", dataType = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", dataType = "int", required = true),
            }
    )
    @GetMapping("/getRegisterMonthCount")
    public R<Integer> getRegisterMonthCount(@RequestParam int year,
                                            @RequestParam int month)
    {
        return success(statisticsService.getRegisterMonthCount(year, month));
    }


    /**
     * 得到某一天聊天发送的条数（一个人可能发送多次聊天）
     *
     * @param year  年
     * @param month 月
     * @param day   天
     * @return {@link R}<{@link Long}> 某一天聊天发送的条数
     */
    @ApiOperation("得到某一天聊天发送的条数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", dataType = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", dataType = "int", required = true),
                    @ApiImplicitParam(name = "day", value = "日", dataType = "int", required = true)
            }
    )
    @GetMapping("/getChatDayCount")
    public R<Long> getChatDayCount(@RequestParam int year,
                                   @RequestParam int month,
                                   @RequestParam int day)
    {
        return success(statisticsService.getChatDayCount(year, month, day));
    }

    /**
     * 得到某一月聊天发送的条数（一个人可能发送多次聊天）
     *
     * @param year  年
     * @param month 月
     * @return {@link R}<{@link Long}> 某一月聊天发送的条数
     */
    @ApiOperation("得到某一月聊天发送的条数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", dataType = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", dataType = "int", required = true)
            }
    )
    @GetMapping("/getChatMonthCount")
    public R<Long> getChatMonthCount(@RequestParam int year,
                                     @RequestParam int month)
    {
        return success(statisticsService.getChatMonthCount(year, month));

    }

    /**
     * 得到某一天群聊聊天发送的条数
     *
     * @param year  年
     * @param month 月
     * @param day   天
     * @return {@link R}<{@link Long}> 某一天群聊聊天消息发送的条数
     */
    @ApiOperation("得到某一天群聊聊天发送的条数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", dataType = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", dataType = "int", required = true),
                    @ApiImplicitParam(name = "day", value = "日", dataType = "int", required = true)
            }
    )
    @GetMapping("/getGroupChatDayCount")
    public R<Long> getGroupChatDayCount(@RequestParam int year,
                                        @RequestParam int month,
                                        @RequestParam int day)
    {
        return success(statisticsService.getGroupChatDayCount(year, month, day));
    }

    /**
     * 得到某一月群聊聊天发送的条数
     *
     * @param year  年
     * @param month 月
     * @return {@link R}<{@link Long}> 某一月群聊聊天消息发送的条数
     */
    @ApiOperation("得到某一月群聊聊天发送的条数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", dataType = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", dataType = "int", required = true)
            }
    )
    @GetMapping("/getGroupChatMonthCount")
    public R<Long> getGroupChatMonthCount(@RequestParam int year,
                                          @RequestParam int month)
    {
        return success(statisticsService.getGroupChatMonthCount(year, month));
    }

    /**
     * 得到某一天群聊创建的次数
     *
     * @param year  年
     * @param month 月
     * @param day   天
     * @return {@link R}<{@link Long}> 某一天群聊创建的次数
     */
    @ApiOperation("得到某一天群聊创建的次数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", dataType = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", dataType = "int", required = true),
                    @ApiImplicitParam(name = "day", value = "日", dataType = "int", required = true)
            }
    )
    @GetMapping("/getGroupCreateDayCount")
    public R<Long> getGroupCreateDayCount(@RequestParam int year,
                                          @RequestParam int month,
                                          @RequestParam int day)
    {
        return success(statisticsService.getGroupCreateDayCount(year, month, day));
    }

    /**
     * 得到某一月群聊创建的次数
     *
     * @param year  年
     * @param month 月
     * @return {@link R}<{@link Long}> 某一月群聊创建的次数
     */
    @ApiOperation("得到某一月群聊创建的次数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", dataType = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", dataType = "int", required = true)
            }
    )
    @GetMapping("/getGroupCreateMonthCount")
    public R<Long> getGroupCreateMonthCount(@RequestParam int year,
                                            @RequestParam int month)
    {
        return success(statisticsService.getGroupCreateMonthCount(year, month));
    }

    /**
     * 得到最近一个月用户每天登录的次数
     *
     * @return {@link Map}<{@link String}, {@link Integer}> map集合，key为时间，value为某个时间用户登录的总次数
     */
    @ApiOperation("得到最近一个月用户每天登录的次数")
    @GetMapping("/getRecentMonthLoginDayCount")
    R<Map<String, Integer>> getRecentMonthLoginDayCount()
    {
        return success(statisticsService.getRecentMonthLoginDayCount());
    }
}
