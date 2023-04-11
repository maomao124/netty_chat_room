package mao.chat_room_manage.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.entity.Statistics;
import mao.chat_room_manage.service.LoginStatisticsService;
import mao.chat_room_server_api.constants.RedisConstants;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.service.impl
 * Class(类名): LoginStatisticsServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/11
 * Time(创建时间)： 14:34
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class LoginStatisticsServiceImpl implements LoginStatisticsService
{

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<Statistics> getRecentMonthLoginDayCount()
    {
        //得到当前时间
        LocalDate now = LocalDate.now();
        List<Statistics> statisticsList = new ArrayList<>(30);
        List<String> keys = new ArrayList<>(30);
        List<String> times = new ArrayList<>(30);
        //当天
        String key = RedisConstants.login_day_count_key + now.getYear() + ":" +
                now.getMonthValue() + ":" + now.getDayOfMonth();
        keys.add(key);
        times.add(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
        for (int i = 1; i < 30; i++)
        {
            LocalDate localDate = now.minusDays(i);
            key = RedisConstants.login_day_count_key + localDate.getYear() + ":" +
                    localDate.getMonthValue() + ":" + localDate.getDayOfMonth();
            keys.add(key);
            times.add(localDate.getYear() + "/" + localDate.getMonthValue() + "/" + localDate.getDayOfMonth());
        }
        List<String> valueList = stringRedisTemplate.opsForValue().multiGet(keys);
        if (valueList == null)
        {
            return statisticsList;
        }
        Iterator<String> iterator = times.iterator();
        for (String value : valueList)
        {
            if (value == null)
            {
                statisticsList.add(new Statistics().setTime(iterator.next()).setCount(0L));
            }
            else
            {
                statisticsList.add(new Statistics().setTime(iterator.next()).setCount(Long.valueOf(value)));
            }
        }
        return statisticsList;
    }

    @Override
    public List<Statistics> getRecentYearLoginMonthCount()
    {
        //得到当前时间
        LocalDate now = LocalDate.now();
        List<Statistics> statisticsList = new ArrayList<>(12);
        List<String> keys = new ArrayList<>(12);
        List<String> times = new ArrayList<>(12);
        //当天
        String key = RedisConstants.login_month_count_key + now.getYear() + ":" +
                now.getMonthValue();
        keys.add(key);
        times.add(now.getYear() + "/" + now.getMonthValue());
        for (int i = 1; i < 12; i++)
        {
            LocalDate localDate = now.minusMonths(i);
            key = RedisConstants.login_month_count_key + localDate.getYear() + ":" +
                    localDate.getMonthValue();
            keys.add(key);
            times.add(localDate.getYear() + "/" + localDate.getMonthValue());
        }
        List<String> valueList = stringRedisTemplate.opsForValue().multiGet(keys);
        if (valueList == null)
        {
            return statisticsList;
        }
        Iterator<String> iterator = times.iterator();
        for (String value : valueList)
        {
            if (value == null)
            {
                statisticsList.add(new Statistics().setTime(iterator.next()).setCount(0L));
            }
            else
            {
                statisticsList.add(new Statistics().setTime(iterator.next()).setCount(Long.valueOf(value)));
            }
        }
        return statisticsList;
    }

    @Override
    public List<Statistics> getRecentMonthLoginDayUVCount()
    {
        //得到当前时间
        LocalDate now = LocalDate.now();
        List<Statistics> statisticsList = new ArrayList<>(30);
        List<String> keys = new ArrayList<>(30);
        List<String> times = new ArrayList<>(30);
        //当天
        String key = RedisConstants.login_day_uv_count_key + now.getYear() + ":" +
                now.getMonthValue() + ":" + now.getDayOfMonth();
        keys.add(key);
        times.add(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
        for (int i = 1; i < 30; i++)
        {
            LocalDate localDate = now.minusDays(i);
            key = RedisConstants.login_day_uv_count_key + localDate.getYear() + ":" +
                    localDate.getMonthValue() + ":" + localDate.getDayOfMonth();
            keys.add(key);
            times.add(localDate.getYear() + "/" + localDate.getMonthValue() + "/" + localDate.getDayOfMonth());
        }

        List<Object> valueList = stringRedisTemplate.executePipelined(new SessionCallback<String>()
        {
            @Override
            @SuppressWarnings("all")
            public String execute(RedisOperations redisOperations) throws DataAccessException
            {
                keys.forEach(s ->
                {
                    redisOperations.opsForHyperLogLog().size(s);
                });
                return null;
            }
        });
        Iterator<String> iterator = times.iterator();
        for (Object value : valueList)
        {
            if (value == null)
            {
                statisticsList.add(new Statistics().setTime(iterator.next()).setCount(0L));
            }
            else
            {
                statisticsList.add(new Statistics().setTime(iterator.next()).setCount(Long.valueOf(value.toString())));
            }
        }
        return statisticsList;
    }

    @Override
    public List<Statistics> getRecentYearLoginMonthUVCount()
    {
        //得到当前时间
        LocalDate now = LocalDate.now();
        List<Statistics> statisticsList = new ArrayList<>(12);
        List<String> keys = new ArrayList<>(12);
        List<String> times = new ArrayList<>(12);
        //当天
        String key = RedisConstants.login_month_uv_count_key + now.getYear() + ":" +
                now.getMonthValue();
        keys.add(key);
        times.add(now.getYear() + "/" + now.getMonthValue());
        for (int i = 1; i < 12; i++)
        {
            LocalDate localDate = now.minusMonths(i);
            key = RedisConstants.login_day_count_key + localDate.getYear() + ":" +
                    localDate.getMonthValue();
            keys.add(key);
            times.add(localDate.getYear() + "/" + localDate.getMonthValue());
        }

        List<Object> valueList = stringRedisTemplate.executePipelined(new SessionCallback<String>()
        {
            @Override
            @SuppressWarnings("all")
            public String execute(RedisOperations redisOperations) throws DataAccessException
            {
                keys.forEach(s ->
                {
                    redisOperations.opsForHyperLogLog().size(s);
                });
                return null;
            }
        });
        Iterator<String> iterator = times.iterator();
        for (Object value : valueList)
        {
            if (value == null)
            {
                statisticsList.add(new Statistics().setTime(iterator.next()).setCount(0L));
            }
            else
            {
                statisticsList.add(new Statistics().setTime(iterator.next()).setCount(Long.valueOf(value.toString())));
            }
        }
        return statisticsList;
    }

    @Override
    public List<Statistics> getLoginDayCountList(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay)
    {
        return null;
    }

    @Override
    public List<Statistics> getLoginMonthCountList(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay)
    {
        return null;
    }

    @Override
    public List<Statistics> getLoginDayUVCountList(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay)
    {
        return null;
    }

    @Override
    public List<Statistics> getLoginMonthUVCountList(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay)
    {
        return null;
    }
}
