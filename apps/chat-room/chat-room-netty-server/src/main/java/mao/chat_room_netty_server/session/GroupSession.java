package mao.chat_room_netty_server.session;

import io.netty.channel.Channel;
import mao.chat_room_netty_server.entity.ClusterGroup;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.session
 * Interface(接口名): GroupSession
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/29
 * Time(创建时间)： 20:54
 * Version(版本): 1.0
 * Description(描述)： 聊天组会话管理接口
 */

public interface GroupSession
{

    /**
     * 得到当前实例下的群聊数量大小
     *
     * @return int
     */
    int getSize();

    /**
     * 得到所有实例下的群聊数量总大小，所有实例群聊数量总和
     *
     * @return int
     */
    int getTotalSize();

    /**
     * 得到本地组信息
     *
     * @return {@link Map}<{@link String}, {@link Group}>
     */
    Map<String, Group> getGroupMap();

    /**
     * 是否有这个组
     *
     * @param name 组名字
     * @return boolean
     */
    boolean hasGroup(String name);

    /**
     * 遍历删除所有群聊，删除移除这个群成员
     *
     * @param username 用户名
     */
    void unbind(String username);

    /**
     * 遍历删除所有群聊，删除移除这个群成员,此方法供消息队列调用
     *
     * @param username 用户名
     */
    void unbindFromMQ(String username);

    /**
     * 创建一个聊天组, 如果不存在才能创建成功, 否则返回 null
     *
     * @param name    组名
     * @param members 成员
     * @return 成功时返回组对象, 失败返回 null
     */
    Group createGroup(String name, Set<String> members);

    /**
     * 加入聊天组
     *
     * @param name   组名
     * @param member 成员名
     * @return 如果组不存在返回 null, 否则返回组对象
     */
    Group joinMember(String name, String member);

    /**
     * 移除组成员
     *
     * @param name   组名
     * @param member 成员名
     * @return 如果组不存在返回 null, 否则返回组对象
     */
    Group removeMember(String name, String member);

    /**
     * 移除聊天组
     *
     * @param name 组名
     * @return 如果组不存在返回 null, 否则返回组对象
     */
    Group removeGroup(String name);

    /**
     * 获取组成员
     *
     * @param name 组名
     * @return 成员集合, 如果群不存在或没有成员会返回 empty set
     */
    Set<String> getMembers(String name);

    /**
     * 获取组成员的 channel 集合, 只有在线的 channel 才会返回
     *
     * @param name 组名
     * @return 成员 channel 集合
     */
    List<Channel> getMembersChannel(String name);


    /**
     * 得到群聊的成员和成员位置和群聊位置
     *
     * @param name 群聊名字
     * @return {@link ClusterGroup}
     */
    ClusterGroup getMembersAndHost(String name);
}
