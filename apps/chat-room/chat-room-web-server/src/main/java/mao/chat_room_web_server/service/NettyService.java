package mao.chat_room_web_server.service;

import mao.chat_room_common.entity.Server;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_web_server.service
 * Interface(接口名): NettyService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 20:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface NettyService
{
    /**
     * 得到netty服务器地址，2级缓存
     *
     * @return {@link Server}
     */
    Server getNettyServerAddress();

    /**
     * 删除缓存
     */
    void removeCache();
}
