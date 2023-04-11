package mao.chat_room_manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.entity.Statistics;
import mao.chat_room_manage.service.LoginStatisticsService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.GetMapping;
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
@RestController("/statistics/login")
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
    R<List<Statistics>> getRecentMonthLoginDayCount()
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
    R<List<Statistics>> getRecentYearLoginMonthCount()
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
    R<List<Statistics>> getRecentMonthLoginDayUVCount()
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
    R<List<Statistics>> getRecentYearLoginMonthUVCount()
    {
        return success(loginStatisticsService.getRecentYearLoginMonthUVCount());
    }
}
