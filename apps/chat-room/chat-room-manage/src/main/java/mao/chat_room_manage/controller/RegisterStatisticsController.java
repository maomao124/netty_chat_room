package mao.chat_room_manage.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.service.RegisterStatisticsService;
import mao.tools_core.base.BaseController;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.controller
 * Class(类名): RegisterStatisticsController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/11
 * Time(创建时间)： 20:38
 * Version(版本): 1.0
 * Description(描述)： 注册统计
 */

@Slf4j
@Api(tags = "注册统计", value = "注册统计")
@RestController("/statistics/register")
public class RegisterStatisticsController extends BaseController
{
    @Resource
    private RegisterStatisticsService registerStatisticsService;


}
