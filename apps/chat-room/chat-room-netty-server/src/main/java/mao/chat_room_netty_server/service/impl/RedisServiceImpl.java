package mao.chat_room_netty_server.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.service.RedisService;
import mao.chat_room_server_api.constants.RedisConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.service.impl
 * Class(类名): RedisServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 15:12
 * Version(版本): 1.0
 * Description(描述)： redis服务实现类,将来多条命令的操作可以使用lua脚本解决来提高性能
 */

@Slf4j
@Service
public class RedisServiceImpl implements RedisService
{
    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void bindToRedis(String username, String host)
    {
        String key1 = RedisConstants.chat_user_key + username;
        String key2 = RedisConstants.chat_user_key + host;
        stringRedisTemplate.opsForValue().set(key1, host);
        stringRedisTemplate.opsForSet().add(key2, username);
    }


    @Override
    public boolean hasLogin(String username)
    {
        String key1 = RedisConstants.chat_user_key + username;
        String host = stringRedisTemplate.opsForValue().get(key1);
        if (host == null || host.equals(""))
        {
            return false;
        }
        return true;
    }

    @Override
    public void unbind(String username)
    {
        String key1 = RedisConstants.chat_user_key + username;
        String host = stringRedisTemplate.opsForValue().get(key1);
        String key2 = RedisConstants.chat_user_key + host;
        stringRedisTemplate.opsForSet().remove(key2, username);
        stringRedisTemplate.delete(key1);
    }

    @Override
    public String getUserHost(String username)
    {
        String key1 = RedisConstants.chat_user_key + username;
        return stringRedisTemplate.opsForValue().get(key1);
    }

    @Override
    public Set<String> getHostUser(String host)
    {
        String key2 = RedisConstants.chat_user_key + host;
        return stringRedisTemplate.opsForSet().members(key2);
    }

    @Override
    public boolean hasGroup(String name)
    {
        String key = RedisConstants.chat_group_key + name;
        return Boolean.TRUE.equals(stringRedisTemplate.hasKey(key));
    }

}
