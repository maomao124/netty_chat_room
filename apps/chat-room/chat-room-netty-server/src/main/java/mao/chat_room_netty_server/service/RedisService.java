package mao.chat_room_netty_server.service;

import java.util.List;
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

    /**
     * 是否存在这个群聊
     *
     * @param name 群聊名字
     * @return boolean
     */
    boolean hasGroup(String name);

    /**
     * 删除群聊成员
     *
     * @param name     群聊名字
     * @param username 用户名
     * @param host     实例的host，比如：127.0.0.1:6379
     * @return boolean
     */
    boolean removeGroupMembers(String name, String username, String host);

    /**
     * 删除群聊
     *
     * @param name 群聊名字
     * @param host 实例的host，比如：127.0.0.1:6379
     * @return boolean
     */
    boolean removeGroup(String name, String host);

    /**
     * 创建组
     *
     * @param name    名字
     * @param members 成员
     * @param host    实例的host，比如：127.0.0.1:6379
     * @return Set<String> 在线成员列表
     */
    Set<String> createGroup(String name, Set<String> members, String host);

    /**
     * 注册计数
     */
    void registerCount();

    /**
     * 登录计数
     *
     * @param username 用户名
     */
    void loginCount(String username);

    /**
     * 从当前实例上解绑群聊
     *
     * @param host 实例的host，比如：127.0.0.1:6379
     */
    void unbindGroup(String host);

    /**
     * 得到群聊的地址
     *
     * @param name 群聊名字
     * @return {@link String} 实例的host，比如：127.0.0.1:6379
     */
    String getGroupAddress(String name);

    /**
     * 加入群聊
     *
     * @param name   群聊名字
     * @param member 成员
     * @param host   实例的host，比如：127.0.0.1:6379
     */
    void joinGroup(String name, String member, String host);
}
