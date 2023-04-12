package mao.chat_room_manage.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import mao.tools_core.base.BaseController;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.controller
 * Class(类名): GroupCreateStatisticsController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/12
 * Time(创建时间)： 13:19
 * Version(版本): 1.0
 * Description(描述)： 群聊创建统计
 */

@Slf4j
@Api(tags = "群聊创建统计", value = "群聊创建统计")
@RestController("/statistics/group/create")
public class GroupCreateStatisticsController extends BaseController
{

}
