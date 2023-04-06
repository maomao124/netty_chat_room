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
 * Description(描述)： 无
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
     * @return int 某一天用户登录的总次数
     */
    @ApiOperation("得到某一天用户登录的总次数")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "year", value = "年", type = "int", required = true),
                    @ApiImplicitParam(name = "month", value = "月", type = "int", required = true),
                    @ApiImplicitParam(name = "day", value = "日", type = "int", required = true)
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
     * @return int 某一月用户登录的总次数
     */
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
     * @return int 某一天用户登录的大致人数
     */
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
     * @return int 某一月用户登录的大致人数
     */
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
     * @return int  某一天用户注册的总次数
     */
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
    public R<Integer> getRegisterMonthCount(@RequestParam int year,
                                            @RequestParam int month)
    {
        return success(statisticsService.getRegisterMonthCount(year, month));
    }
}
