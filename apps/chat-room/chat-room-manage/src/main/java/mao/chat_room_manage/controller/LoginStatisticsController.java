package mao.chat_room_manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.entity.Statistics;
import mao.chat_room_manage.service.LoginStatisticsService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.controller
 * Class(类名): LoginStatisticsController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/11
 * Time(创建时间)： 14:32
 * Version(版本): 1.0
 * Description(描述)： 登录统计
 */

@Slf4j
@Api(tags = "登录统计", value = "登录统计")
@RestController
@RequestMapping("/statistics/login")
public class LoginStatisticsController extends BaseController
{
    @Resource
    private LoginStatisticsService loginStatisticsService;

    /**
     * 得到最近一个月用户每天登录的次数
     *
     * @return {@link R}<{@link List}<{@link Statistics}>> Statistics列表
     */
    @ApiOperation("得到最近一个月用户每天登录的次数")
    @GetMapping("/getRecentMonthLoginDayCount")
    public R<List<Statistics>> getRecentMonthLoginDayCount()
    {
        return success(loginStatisticsService.getRecentMonthLoginDayCount());
    }


    /**
     * 得到最近一年每个月用户登录的次数
     *
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    @ApiOperation("得到最近一年每个月用户登录的次数")
    @GetMapping("/getRecentYearLoginMonthCount")
    public R<List<Statistics>> getRecentYearLoginMonthCount()
    {
        return success(loginStatisticsService.getRecentYearLoginMonthCount());
    }

    /**
     * 得到最近一个月用户每天登录的大致人数 （一个人可能登录多次，但是只记录一次）
     *
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    @ApiOperation("得到最近一个月用户每天登录的大致人数")
    @GetMapping("/getRecentMonthLoginDayUVCount")
    public R<List<Statistics>> getRecentMonthLoginDayUVCount()
    {
        return success(loginStatisticsService.getRecentMonthLoginDayUVCount());
    }

    /**
     * 得到最近一年每个月用户登录的大致人数 （一个人可能登录多次，但是只记录一次）
     *
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    @ApiOperation("得到最近一年每个月用户登录的大致人数")
    @GetMapping("/getRecentYearLoginMonthUVCount")
    public R<List<Statistics>> getRecentYearLoginMonthUVCount()
    {
        return success(loginStatisticsService.getRecentYearLoginMonthUVCount());
    }


    /**
     * 得到用户某些天用户登录的次数
     *
     * @param startYear  起始年
     * @param startMonth 起始月
     * @param startDay   起始天
     * @param endYear    结束年
     * @param endMonth   结束月
     * @param endDay     结束天
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    @ApiOperation("得到用户某些天用户登录的次数")
    @GetMapping("/getLoginDayCountList")
    @ApiImplicitParams
            (
                    {
                            @ApiImplicitParam(name = "startYear", value = "起始年",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "startMonth", value = "起始月",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "startDay", value = "起始天",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "endYear", value = "结束年",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "endMonth", value = "结束月",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "endDay", value = "结束天",
                                    dataType = "int", required = true)
                    }
            )
    public R<List<Statistics>> getLoginDayCountList(@RequestParam int startYear,
                                                    @RequestParam int startMonth,
                                                    @RequestParam int startDay,
                                                    @RequestParam int endYear,
                                                    @RequestParam int endMonth,
                                                    @RequestParam int endDay)
    {
        return success(loginStatisticsService.getLoginDayCountList(startYear, startMonth,
                startDay, endYear, endMonth, endDay));
    }

    /**
     * 得到用户某些月用户登录的次数
     *
     * @param startYear  起始年
     * @param startMonth 起始月
     * @param endYear    结束年
     * @param endMonth   结束月
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    @ApiOperation("得到用户某些月用户登录的次数")
    @GetMapping("/getLoginMonthCountList")
    @ApiImplicitParams
            (
                    {
                            @ApiImplicitParam(name = "startYear", value = "起始年",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "startMonth", value = "起始月",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "endYear", value = "结束年",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "endMonth", value = "结束月",
                                    dataType = "int", required = true)
                    }
            )
    public R<List<Statistics>> getLoginMonthCountList(@RequestParam int startYear,
                                                      @RequestParam int startMonth,
                                                      @RequestParam int endYear,
                                                      @RequestParam int endMonth)
    {
        return success(loginStatisticsService.getLoginMonthCountList(startYear, startMonth,
                endYear, endMonth));
    }

    /**
     * 得到用户某些天用户登录的大致人数
     *
     * @param startYear  起始年
     * @param startMonth 起始月
     * @param startDay   起始天
     * @param endYear    结束年
     * @param endMonth   结束月
     * @param endDay     结束天
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    @ApiOperation("得到用户某些天用户登录的大致人数")
    @GetMapping("/getLoginDayUVCountList")
    @ApiImplicitParams
            (
                    {
                            @ApiImplicitParam(name = "startYear", value = "起始年",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "startMonth", value = "起始月",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "startDay", value = "起始天",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "endYear", value = "结束年",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "endMonth", value = "结束月",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "endDay", value = "结束天",
                                    dataType = "int", required = true)
                    }
            )
    public R<List<Statistics>> getLoginDayUVCountList(@RequestParam int startYear,
                                                      @RequestParam int startMonth,
                                                      @RequestParam int startDay,
                                                      @RequestParam int endYear,
                                                      @RequestParam int endMonth,
                                                      @RequestParam int endDay)
    {
        return success(loginStatisticsService.getLoginDayUVCountList(startYear, startMonth,
                startDay, endYear, endMonth, endDay));
    }

    /**
     * 得到用户某些月用户登录的大致人数
     *
     * @param startYear  起始年
     * @param startMonth 起始月
     * @param endYear    结束年
     * @param endMonth   结束月
     * @return {@link List}<{@link Statistics}> Statistics列表
     */
    @ApiOperation("得到用户某些月用户登录的大致人数")
    @GetMapping("/getLoginMonthUVCountList")
    @ApiImplicitParams
            (
                    {
                            @ApiImplicitParam(name = "startYear", value = "起始年",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "startMonth", value = "起始月",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "endYear", value = "结束年",
                                    dataType = "int", required = true),
                            @ApiImplicitParam(name = "endMonth", value = "结束月",
                                    dataType = "int", required = true),
                    }
            )
    public R<List<Statistics>> getLoginMonthUVCountList(@RequestParam int startYear,
                                                        @RequestParam int startMonth,
                                                        @RequestParam int endYear,
                                                        @RequestParam int endMonth)
    {
        return success(loginStatisticsService.getLoginMonthUVCountList(startYear, startMonth,
                endYear, endMonth));
    }
}
