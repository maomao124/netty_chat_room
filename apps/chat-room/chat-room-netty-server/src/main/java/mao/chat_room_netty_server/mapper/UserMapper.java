package mao.chat_room_netty_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.chat_room_server_api.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.mapper
 * Interface(接口名): UserMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 22:13
 * Version(版本): 1.0
 * Description(描述)： 用户相关mapper
 */

@Mapper
public interface UserMapper extends BaseMapper<User>
{

}
