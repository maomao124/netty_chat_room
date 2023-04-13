package mao.chat_room_server_api.constants;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_server_api.constants
 * Class(类名): RedisConstants
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 14:57
 * Version(版本): 1.0
 * Description(描述)： redis 常量类，这里都小写
 */

public class RedisConstants
{
    public static final String chat_user_key = "chat_room:user:";

    public static final String chat_group_key = "chat_room:group:";

    public static final String chat_group_list_key = "chat_room:group:list:";

    public static final String register_day_count_key = "chat_room:register:day:";

    public static final String register_month_count_key = "chat_room:register:month:";

    public static final String login_day_count_key = "chat_room:login:count:day:";

    public static final String login_month_count_key = "chat_room:login:count:month:";

    public static final String login_day_uv_count_key = "chat_room:login:uv:day:";

    public static final String login_month_uv_count_key = "chat_room:login:uv:month:";

    public static final String chat_day_count_key = "chat_room:chat:count:day:";

    public static final String group_chat_day_count_key = "chat_room:chat:group:count:day:";

    public static final String group_create_day_count_key = "chat_room:create:group:count:day:";

    public static final String chat_month_count_key = "chat_room:chat:count:month:";

    public static final String group_chat_month_count_key = "chat_room:chat:group:count:month:";

    public static final String group_create_month_count_key = "chat_room:create:group:count:month:";

    public static final String re_balance_lock_key = "chat_room:re_balance:lock";

    public static final String re_balance_time_key = "chat_room:re_balance:time";


}
