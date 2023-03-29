package mao.chat_room_netty_server.session;

import lombok.Data;

import java.util.Collections;
import java.util.Set;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.session
 * Class(类名): Group
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/29
 * Time(创建时间)： 20:51
 * Version(版本): 1.0
 * Description(描述)： 聊天室
 */

@Data
public class Group
{

    /**
     * 聊天室名称
     */
    private String name;

    /**
     * 聊天室成员
     */
    private Set<String> members;

    /**
     * 空组
     */
    public static final Group EMPTY_GROUP = new Group("empty", Collections.emptySet());

    public Group(String name, Set<String> members)
    {
        this.name = name;
        this.members = members;
    }
}
