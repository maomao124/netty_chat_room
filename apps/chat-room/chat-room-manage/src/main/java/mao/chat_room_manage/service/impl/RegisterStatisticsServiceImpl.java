package mao.chat_room_manage.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.entity.Statistics;
import mao.chat_room_manage.service.RegisterStatisticsService;
import mao.chat_room_manage.utils.LocalDateUtils;
import mao.chat_room_server_api.constants.RedisConstants;
import mao.tools_core.exception.BizException;
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
 * Class(类名): RegisterStatisticsServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/11
 * Time(创建时间)： 20:39
 * Version(版本): 1.0
 * Description(描述)： 注册统计服务实现类
 */

@Slf4j
@Service
public class RegisterStatisticsServiceImpl implements RegisterStatisticsService
{

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<Statistics> getRecentMonthRegisterDayCount()
    {
        //得到当前时间
        LocalDate now = LocalDate.now();
        List<Statistics> statisticsList = new ArrayList<>(30);
        List<String> keys = new ArrayList<>(30);
        List<String> times = new ArrayList<>(30);
        //当天
        String key = RedisConstants.register_day_count_key + now.getYear() + ":" +
                now.getMonthValue() + ":" + now.getDayOfMonth();
        keys.add(key);
        times.add(now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth());
        for (int i = 1; i < 30; i++)
        {
            LocalDate localDate = now.minusDays(i);
            key = RedisConstants.register_day_count_key + localDate.getYear() + ":" +
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
    public List<Statistics> getRecentYearRegisterMonthCount()
    {
        //得到当前时间
        LocalDate now = LocalDate.now();
        List<Statistics> statisticsList = new ArrayList<>(12);
        List<String> keys = new ArrayList<>(12);
        List<String> times = new ArrayList<>(12);
        //当天
        String key = RedisConstants.register_month_count_key + now.getYear() + ":" +
                now.getMonthValue();
        keys.add(key);
        times.add(now.getYear() + "/" + now.getMonthValue());
        for (int i = 1; i < 12; i++)
        {
            LocalDate localDate = now.minusMonths(i);
            key = RedisConstants.register_month_count_key + localDate.getYear() + ":" +
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
    public List<Statistics> getRegisterDayCountList(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay)
    {
        LocalDateUtils.handlerYear(startYear);
        LocalDateUtils.handlerMonth(startMonth);
        LocalDateUtils.handlerDay(startDay);
        LocalDateUtils.handlerYear(endYear);
        LocalDateUtils.handlerMonth(endMonth);
        LocalDateUtils.handlerDay(endDay);
        //构建时间
        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);
        //不能晚于现在时间
        LocalDateUtils.isAfterNow(endDate);
        //得到天数差值
        long dayTimeDifference = LocalDateUtils.getDayTimeDifference(startDate, endDate);
        //防止时间间隔太长
        if (dayTimeDifference > 1000)
        {
            throw BizException.wrap("时间间隔太长");
        }
        log.debug("开始日期：" + startDate + ", 结束日期：" + endDate);
        log.debug("天数差值：" + dayTimeDifference);

        dayTimeDifference++;

        List<Statistics> statisticsList = new ArrayList<>(Math.toIntExact(dayTimeDifference));
        List<String> keys = new ArrayList<>(Math.toIntExact(dayTimeDifference));
        List<String> times = new ArrayList<>(Math.toIntExact(dayTimeDifference));
        String key = RedisConstants.register_day_count_key + endDate.getYear() + ":" +
                endDate.getMonthValue() + ":" + endDate.getDayOfMonth();
        keys.add(key);
        times.add(endDate.getYear() + "/" + endDate.getMonthValue() + "/" + endDate.getDayOfMonth());
        for (int i = 1; i < dayTimeDifference; i++)
        {
            LocalDate localDate = endDate.minusDays(i);
            key = RedisConstants.register_day_count_key + localDate.getYear() + ":" +
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
    public List<Statistics> getRegisterMonthCountList(int startYear, int startMonth, int endYear, int endMonth)
    {
        LocalDateUtils.handlerYear(startYear);
        LocalDateUtils.handlerMonth(startMonth);
        LocalDateUtils.handlerYear(endYear);
        LocalDateUtils.handlerMonth(endMonth);
        //构建时间
        LocalDate startDate = LocalDate.of(startYear, startMonth, 1);
        LocalDate endDate = LocalDate.of(endYear, endMonth, 1);
        //不能晚于现在时间
        LocalDateUtils.isAfterNow(endDate);
        //得到月数差值
        long monthTimeDifference = LocalDateUtils.getMonthTimeDifference(startDate, endDate);
        //防止时间间隔太长
        if (monthTimeDifference > 240)
        {
            throw BizException.wrap("时间间隔太长");
        }
        log.debug("开始日期：" + startDate + ", 结束日期：" + endDate);
        log.debug("月数差值：" + monthTimeDifference);

        monthTimeDifference++;

        List<Statistics> statisticsList = new ArrayList<>(Math.toIntExact(monthTimeDifference));
        List<String> keys = new ArrayList<>(Math.toIntExact(monthTimeDifference));
        List<String> times = new ArrayList<>(Math.toIntExact(monthTimeDifference));
        //当天
        String key = RedisConstants.register_month_count_key + endDate.getYear() + ":" +
                endDate.getMonthValue();
        keys.add(key);
        times.add(endDate.getYear() + "/" + endDate.getMonthValue());
        for (int i = 1; i < Math.toIntExact(monthTimeDifference); i++)
        {
            LocalDate localDate = endDate.minusMonths(i);
            key = RedisConstants.register_month_count_key + localDate.getYear() + ":" +
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
}
