package mao.chat_room_netty_server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.service.ReBalanceService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.controller
 * Class(类名): ReBalanceController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/13
 * Time(创建时间)： 15:33
 * Version(版本): 1.0
 * Description(描述)： 负载均衡相关
 */

@Slf4j
@Api(value = "reBalance", tags = "reBalance")
@RestController
@RequestMapping("/reBalance")
public class ReBalanceController extends BaseController
{
    @Resource
    private ReBalanceService reBalanceService;


    /**
     * ReBalance处理
     * 随机从用户列表中抽 reBalanceNumber 的数量的用户，让他们重新负载均衡到 host 这个新实例上
     * 比如reBalanceNumber为7，host为56.87.28.29:2457 ，随机抽7个用户让他们重新连接到56.87.28.29:2457这个host上
     *
     * @param host            实例的地址
     * @param reBalanceNumber 重新平衡的数量
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping("/handler")
    @ApiOperation("ReBalance处理")
    public R<Boolean> handler(@RequestParam String host,
                              @RequestParam int reBalanceNumber)
    {
        reBalanceService.handler(host, reBalanceNumber);
        return success();
    }
}
