package mao.chat_room_server_api.constants;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_server_api.constants
 * Class(类名): UrlConstants
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 19:29
 * Version(版本): 1.0
 * Description(描述)： url 常量
 */

public class UrlConstants
{
    public static final String prefix = "http://";


    /**
     * 构建聊天请求url
     *
     * @param host 主机地址
     * @return {@link String} url
     */
    public static String buildChatRequestMessageUrl(String host)
    {
        return prefix + host + "/send";
    }

    /**
     * 构建得到netty端口号的url
     *
     * @param host 宿主
     * @return {@link String} url
     */
    public static String buildGetPortUrl(String host)
    {
        return prefix + host + "/port";
    }

    /**
     * 构建群聊创建请求url
     *
     * @param host 主机地址
     * @return {@link String} url
     */
    public static String buildGroupCreateRequestMessageUrl(String host)
    {
        return prefix + host + "/sendGroupCreateMessage";
    }


    /**
     * 构建群聊聊天请求url
     *
     * @param host 主机地址
     * @return {@link String} url
     */
    public static String buildGroupChatRequestMessageUrl(String host)
    {
        return prefix + host + "/sendGroupChatMessage";
    }

    /**
     * 构建成员加入本地群聊url
     *
     * @param host   主机地址
     * @param name   群聊名字
     * @param member 群聊成员
     * @return {@link String} url
     */
    public static String buildJoinMemberUrl(String host, String name, String member)
    {
        return prefix + host + "/joinMember?name=" + name + "&member=" + member;
    }

    /**
     * 构建成员退出本地群聊url
     *
     * @param host   主机地址
     * @param name   群聊名字
     * @param member 群聊成员
     * @return {@link String} url
     */
    public static String buildRemoveMemberUrl(String host, String name, String member)
    {
        return prefix + host + "/removeMember?name=" + name + "&member=" + member;
    }


}
