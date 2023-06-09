package mao.chat_room_manage.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.service.StatisticsService;
import mao.chat_room_manage.utils.LocalDateUtils;
import mao.chat_room_server_api.constants.RedisConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service.impl
 * Class(类名): StatisticsServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/6
 * Time(创建时间)： 13:59
 * Version(版本): 1.0
 * Description(描述)： 统计服务实现类
 */

@Slf4j
@Service
public class StatisticsServiceImpl implements StatisticsService
{

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public int getLoginDayCount(int year, int month, int day)
    {
        LocalDateUtils.handlerYear(year);
        LocalDateUtils.handlerMonth(month);
        LocalDateUtils.handlerDay(day);
        String key = RedisConstants.login_day_count_key + year + ":" + month + ":" + day;
        String count = stringRedisTemplate.opsForValue().get(key);
        if (count == null)
        {
            return 0;
        }
        return Integer.parseInt(count);
    }

    @Override
    public int getLoginMonthCount(int year, int month)
    {
        LocalDateUtils.handlerYear(year);
        LocalDateUtils.handlerMonth(month);
        String key = RedisConstants.login_month_count_key + year + ":" + month;
        String count = stringRedisTemplate.opsForValue().get(key);
        if (count == null)
        {
            return 0;
        }
        return Integer.parseInt(count);
    }

    @Override
    public int getLoginDayUVCount(int year, int month, int day)
    {
        LocalDateUtils.handlerYear(year);
        LocalDateUtils.handlerMonth(month);
        LocalDateUtils.handlerDay(day);
        String key = RedisConstants.login_day_uv_count_key + year + ":" + month + ":" + day;
        Long size = stringRedisTemplate.opsForHyperLogLog().size(key);
        return Math.toIntExact(size);
    }

    @Override
    public int getLoginMonthUVCount(int year, int month)
    {
        LocalDateUtils.handlerYear(year);
        LocalDateUtils.handlerMonth(month);
        String key = RedisConstants.login_month_uv_count_key + year + ":" + month;
        Long size = stringRedisTemplate.opsForHyperLogLog().size(key);
        return Math.toIntExact(size);
    }

    @Override
    public int getRegisterDayCount(int year, int month, int day)
    {
        LocalDateUtils.handlerYear(year);
        LocalDateUtils.handlerMonth(month);
        LocalDateUtils.handlerDay(day);
        String key = RedisConstants.register_day_count_key + year + ":" + month + ":" + day;
        String count = stringRedisTemplate.opsForValue().get(key);
        if (count == null)
        {
            return 0;
        }
        return Integer.parseInt(count);
    }

    @Override
    public int getRegisterMonthCount(int year, int month)
    {
        LocalDateUtils.handlerYear(year);
        LocalDateUtils.handlerMonth(month);
        String key = RedisConstants.register_month_count_key + year + ":" + month;
        String count = stringRedisTemplate.opsForValue().get(key);
        if (count == null)
        {
            return 0;
        }
        return Integer.parseInt(count);
    }

    @Override
    public long getChatDayCount(int year, int month, int day)
    {
        LocalDateUtils.handlerYear(year);
        LocalDateUtils.handlerMonth(month);
        LocalDateUtils.handlerDay(day);
        String key = RedisConstants.chat_day_count_key + year + ":" + month + ":" + day;
        String count = stringRedisTemplate.opsForValue().get(key);
        if (count == null)
        {
            return 0L;
        }
        return Long.parseLong(count);
    }

    @Override
    public long getChatMonthCount(int year, int month)
    {
        LocalDateUtils.handlerYear(year);
        LocalDateUtils.handlerMonth(month);
        String key = RedisConstants.chat_month_count_key + year + ":" + month;
        String count = stringRedisTemplate.opsForValue().get(key);
        if (count == null)
        {
            return 0L;
        }
        return Long.parseLong(count);
    }

    @Override
    public long getGroupChatDayCount(int year, int month, int day)
    {
        LocalDateUtils.handlerYear(year);
        LocalDateUtils.handlerMonth(month);
        LocalDateUtils.handlerDay(day);
        String key = RedisConstants.group_chat_day_count_key + year + ":" + month + ":" + day;
        String count = stringRedisTemplate.opsForValue().get(key);
        if (count == null)
        {
            return 0L;
        }
        return Long.parseLong(count);
    }

    @Override
    public long getGroupChatMonthCount(int year, int month)
    {
        LocalDateUtils.handlerYear(year);
        LocalDateUtils.handlerMonth(month);
        String key = RedisConstants.group_chat_month_count_key + year + ":" + month;
        String count = stringRedisTemplate.opsForValue().get(key);
        if (count == null)
        {
            return 0L;
        }
        return Long.parseLong(count);
    }

    @Override
    public long getGroupCreateDayCount(int year, int month, int day)
    {
        LocalDateUtils.handlerYear(year);
        LocalDateUtils.handlerMonth(month);
        LocalDateUtils.handlerDay(day);
        String key = RedisConstants.group_create_day_count_key + year + ":" + month + ":" + day;
        String count = stringRedisTemplate.opsForValue().get(key);
        if (count == null)
        {
            return 0L;
        }
        return Long.parseLong(count);
    }

    @Override
    public long getGroupCreateMonthCount(int year, int month)
    {
        LocalDateUtils.handlerYear(year);
        LocalDateUtils.handlerMonth(month);
        String key = RedisConstants.group_create_month_count_key + year + ":" + month;
        String count = stringRedisTemplate.opsForValue().get(key);
        if (count == null)
        {
            return 0L;
        }
        return Long.parseLong(count);
    }

}
