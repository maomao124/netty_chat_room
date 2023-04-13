package mao.chat_room_netty_server.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.service.ReBalanceService;
import mao.chat_room_netty_server.session.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.service.impl
 * Class(类名): ReBalanceServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/13
 * Time(创建时间)： 15:43
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class ReBalanceServiceImpl implements ReBalanceService
{

    @Resource
    private Session session;

    @Override
    public void handler(String host, int reBalanceNumber)
    {
        log.debug("触发ReBalance，数量：" + reBalanceNumber + ", 位置：" + host);

    }
}
