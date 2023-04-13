package mao.chat_room_manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.entity.Statistics;
import mao.chat_room_manage.service.GroupChatStatisticsService;
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
 * Class(类名): GroupChatStatisticsController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/11
 * Time(创建时间)： 21:16
 * Version(版本): 1.0
 * Description(描述)： 群聊聊天消息统计
 */

@Slf4j
@Api(tags = "群聊聊天消息统计", value = "群聊聊天消息统计")
@RestController
@RequestMapping("/statistics/group/chat")
public class GroupChatStatisticsController extends BaseController
{

    @Resource
    private GroupChatStatisticsService groupChatStatisticsService;

    /**
     * 得到最近一个月每天发送群聊聊天消息的总数
     *
     * @return {@link R}<{@link List}<{@link Statistics}>> Statistics列表
     */
    @ApiOperation("得到最近一个月每天发送群聊聊天消息的总数")
    @GetMapping("/getRecentMonthGroupChatDayCount")
    public R<List<Statistics>> getRecentMonthGroupChatDayCount()
    {
        return success(groupChatStatisticsService.getRecentMonthGroupChatDayCount());
    }

    /**
     * 得到最近一年每个月发送群聊聊天消息的总数
     *
     * @return {@link R}<{@link List}<{@link Statistics}>> Statistics列表
     */
    @ApiOperation("得到最近一年每个月发送群聊聊天消息的总数")
    @GetMapping("/getRecentYearGroupChatMonthCount")
    public R<List<Statistics>> getRecentYearGroupChatMonthCount()
    {
        return success(groupChatStatisticsService.getRecentYearGroupChatMonthCount());
    }


    /**
     * 得到用户某些天发送群聊聊天消息的总数
     *
     * @param startYear  起始年
     * @param startMonth 起始月
     * @param startDay   起始天
     * @param endYear    结束年
     * @param endMonth   结束月
     * @param endDay     结束天
     * @return {@link R}<{@link List}<{@link Statistics}>> Statistics列表
     */
    @ApiOperation("得到用户某些天发送群聊聊天消息的总数")
    @GetMapping("/getChatDayGroupCountList")
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
    public R<List<Statistics>> getChatDayGroupCountList(@RequestParam int startYear,
                                                        @RequestParam int startMonth,
                                                        @RequestParam int startDay,
                                                        @RequestParam int endYear,
                                                        @RequestParam int endMonth,
                                                        @RequestParam int endDay)
    {
        return success(groupChatStatisticsService.getChatDayGroupCountList(startYear, startMonth,
                startDay, endYear, endMonth, endDay));
    }

    /**
     * 得到用户某些月发送群聊聊天消息的总数
     *
     * @param startYear  起始年
     * @param startMonth 起始月
     * @param endYear    结束年
     * @param endMonth   结束月
     * @return {@link R}<{@link List}<{@link Statistics}>> Statistics列表
     */
    @ApiOperation("得到用户某些月发送群聊聊天消息的总数")
    @GetMapping("/getChatMonthGroupCountList")
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
    public R<List<Statistics>> getChatMonthGroupCountList(@RequestParam int startYear,
                                                          @RequestParam int startMonth,
                                                          @RequestParam int endYear,
                                                          @RequestParam int endMonth)
    {
        return success(groupChatStatisticsService.getChatMonthGroupCountList(startYear, startMonth,
                endYear, endMonth));
    }
}
