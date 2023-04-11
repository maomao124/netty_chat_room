package mao.chat_room_manage.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.chat_room_manage.entity.Statistics;
import mao.chat_room_manage.service.RegisterStatisticsService;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Statistics> getRecentMonthRegisterDayCount()
    {
        return null;
    }

    @Override
    public List<Statistics> getRecentYearRegisterMonthCount()
    {
        return null;
    }

    @Override
    public List<Statistics> getRegisterDayCountList(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay)
    {
        return null;
    }

    @Override
    public List<Statistics> getRegisterMonthCountList(int startYear, int startMonth, int endYear, int endMonth)
    {
        return null;
    }
}
