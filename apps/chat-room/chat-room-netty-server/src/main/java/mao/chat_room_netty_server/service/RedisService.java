package mao.chat_room_netty_server.service;

import java.util.Set;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.service
 * Interface(接口名): RedisService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 15:12
 * Version(版本): 1.0
 * Description(描述)： redis服务
 */

public interface RedisService
{
    /**
     * 绑定到redis
     *
     * @param username 用户名
     * @param host     主机地址，例如：127.0.0.1:6379
     */
    void bindToRedis(String username, String host);

    /**
     * 是否是登录状态
     *
     * @param username 用户名
     * @return boolean
     */
    boolean hasLogin(String username);

    /**
     * 解绑
     *
     * @param username 用户名
     */
    void unbind(String username);

    /**
     * 得到用户所在的服务实例的位置
     *
     * @param username 用户名
     * @return {@link String} 实例的host，比如：127.0.0.1:6379
     */
    String getUserHost(String username);

    /**
     * 得到某个实例上登录的所有用户信息
     *
     * @param host 宿主
     * @return {@link Set}<{@link String}> 用户名集合
     */
    Set<String> getHostUser(String host);
}