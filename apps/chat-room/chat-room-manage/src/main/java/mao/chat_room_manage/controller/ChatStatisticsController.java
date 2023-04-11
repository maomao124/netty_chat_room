package mao.chat_room_manage.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import mao.tools_core.base.BaseController;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.controller
 * Class(类名): ChatStatisticsController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/11
 * Time(创建时间)： 21:02
 * Version(版本): 1.0
 * Description(描述)： 聊天消息统计
 */

@Slf4j
@Api(tags = "聊天消息统计", value = "聊天消息统计")
@RestController("/statistics/chat")
public class ChatStatisticsController extends BaseController
{

}
