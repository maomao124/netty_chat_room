package mao.chat_room_netty_server.session;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_netty_server.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.session
 * Class(类名): SessionClusterImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 14:47
 * Version(版本): 1.0
 * Description(描述)： 集群会话管理接口实现类
 */

@Slf4j
public class SessionClusterImpl implements Session
{

    private final RedisService redisService;

    /**
     * 主机地址
     */
    private final String hostAddress;


    private final String host;

    public SessionClusterImpl(@Value("${server.port}") String port, RedisService redisService)
            throws UnknownHostException
    {
        hostAddress = InetAddress.getLocalHost().getHostAddress();
        this.redisService = redisService;
        this.host = hostAddress + ":" + port;

    }

    /**
     * 用户名通道映射
     */
    private final Map<String, Channel> usernameChannelMap = new ConcurrentHashMap<>();

    /**
     * channel用户名映射
     */
    private final Map<Channel, String> channelUsernameMap = new ConcurrentHashMap<>();

    /**
     * 通道属性映射
     */
    private final Map<Channel, Map<String, Object>> channelAttributesMap = new ConcurrentHashMap<>();

    @Override
    public int getSize()
    {
        return usernameChannelMap.size();
    }

    @Override
    public int getTotalSize()
    {
        return 0;
    }

    @Override
    public void bind(Channel channel, String username)
    {
        log.debug("用户：" + username + "绑定会话");
        usernameChannelMap.put(username, channel);
        channelUsernameMap.put(channel, username);
        channelAttributesMap.put(channel, new ConcurrentHashMap<>());

        redisService.bindToRedis(username, host);
    }

    @Override
    public void unbind(Channel channel)
    {
        //得到用户名
        String username = channelUsernameMap.remove(channel);
        if (username == null)
        {
            log.debug("未登录用户断开连接");
        }
        else
        {
            log.debug("用户：" + username + "解除绑定会话");
        }
        //移除
        try
        {
            redisService.unbind(username);
            usernameChannelMap.remove(username);
        }
        catch (Exception ignored)
        {

        }
        try
        {
            channelUsernameMap.remove(channel);
        }
        catch (Exception ignored)
        {

        }
        try
        {
            channelAttributesMap.remove(channel);
        }
        catch (Exception ignored)
        {

        }
    }

    @Override
    public boolean isLogin(String username)
    {
        Channel channel = usernameChannelMap.get(username);
        if (channel != null)
        {
            return true;
        }
        //在本地未找到
        boolean hasLogin = redisService.hasLogin(username);
        if (hasLogin)
        {
            log.debug("用户" + username + "在其它服务实例上登录");
            return true;
        }
        log.debug("用户" + username + "未登录");
        return false;
    }

    @Override
    public boolean isLogin(Channel channel)
    {
        String username = channelUsernameMap.get(channel);
        if (username == null)
        {
            log.debug("用户" + channel + "未登录");
            return false;
        }
        return true;
    }

    @Override
    public Object getAttribute(Channel channel, String name)
    {
        log.debug("得到" + name + "的属性值");
        return channelAttributesMap.get(channel).get(name);
    }

    @Override
    public void setAttribute(Channel channel, String name, Object value)
    {
        log.debug("设置属性" + name + "--->" + value);
        Map<String, Object> map = channelAttributesMap.get(channel);
        map.put(name, value);
    }

    @Override
    public Channel getChannel(String username)
    {
        log.debug("根据用户名获取channel：" + username);
        return usernameChannelMap.get(username);
    }

    @Override
    public String getUsername(Channel channel)
    {
        return channelUsernameMap.get(channel);
    }
}
