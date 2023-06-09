package mao.chat_room_netty_server.session;

import io.netty.channel.Channel;

import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.session
 * Interface(接口名): Session
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/29
 * Time(创建时间)： 20:52
 * Version(版本): 1.0
 * Description(描述)： 会话管理接口
 */

public interface Session
{
    /**
     * 得到当前实例下的在线人数大小
     *
     * @return int
     */
    int getSize();

    /**
     * 得到所有实例下的在线人数总大小，所有实例在线人数总和
     *
     * @return int
     */
    int getTotalSize();

    /**
     * 绑定会话
     *
     * @param channel  哪个 channel 要绑定会话
     * @param username 会话绑定用户
     */
    void bind(Channel channel, String username);

    /**
     * 解绑会话
     *
     * @param channel 哪个 channel 要解绑会话
     */
    void unbind(Channel channel);

    /**
     * 是否是登录状态
     *
     * @param username 用户名
     * @return boolean
     */
    boolean isLogin(String username);

    /**
     * 是否是登录状态
     *
     * @param channel 通道
     * @return boolean
     */
    boolean isLogin(Channel channel);

    /**
     * 获取属性
     *
     * @param channel 哪个 channel
     * @param name    属性名
     * @return 属性值
     */
    Object getAttribute(Channel channel, String name);

    /**
     * 设置属性
     *
     * @param channel 哪个 channel
     * @param name    属性名
     * @param value   属性值
     */
    void setAttribute(Channel channel, String name, Object value);

    /**
     * 根据用户名获取 channel
     *
     * @param username 用户名
     * @return channel
     */
    Channel getChannel(String username);

    /**
     * 根据Channel获取用户名
     *
     * @param channel 通道
     * @return 用户名
     */
    String getUsername(Channel channel);


    /**
     * 重新平衡
     *
     * @param reBalanceNumber 重新平衡数量
     * @return {@link List}<{@link Channel}>
     */
    List<Channel> reBalance(int reBalanceNumber);
}
