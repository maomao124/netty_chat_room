package mao.chat_room_manage.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
class LoginStatisticsServiceImplTest
{
    @Autowired
    private LoginStatisticsServiceImpl loginStatisticsServiceImpl;

    /**
     * Method under test: {@link LoginStatisticsServiceImpl#getRecentMonthLoginDayCount()}
     */
    @Test
    void testGetRecentMonthLoginDayCount()
    {
        System.out.println(this.loginStatisticsServiceImpl.getRecentMonthLoginDayCount());
    }

    /**
     * Method under test: {@link LoginStatisticsServiceImpl#getRecentYearLoginMonthCount()}
     */
    @Test

    void testGetRecentYearLoginMonthCount()
    {
        System.out.println(this.loginStatisticsServiceImpl.getRecentYearLoginMonthCount());
    }

    /**
     * Method under test: {@link LoginStatisticsServiceImpl#getRecentMonthLoginDayUVCount()}
     */
    @Test
    void testGetRecentMonthLoginDayUVCount()
    {
        System.out.println(this.loginStatisticsServiceImpl.getRecentMonthLoginDayUVCount());
    }

    /**
     * Method under test: {@link LoginStatisticsServiceImpl#getRecentYearLoginMonthUVCount()}
     */
    @Test
    void testGetRecentYearLoginMonthUVCount()
    {
        System.out.println(this.loginStatisticsServiceImpl.getRecentYearLoginMonthUVCount());
    }
    
}

