package mao.chat_room_manage.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@SpringBootTest
class StatisticsServiceImplTest
{
    @Autowired
    private StatisticsServiceImpl statisticsServiceImpl;

    /**
     * Method under test: {@link StatisticsServiceImpl#getLoginDayCount(int, int, int)}
     */
    @Test
    void testGetLoginDayCount()
    {
        System.out.println(this.statisticsServiceImpl.getLoginDayCount(2023, 4, 4));
    }

    /**
     * Method under test: {@link StatisticsServiceImpl#getLoginDayCount(int, int, int)}
     */
    @Test
    void testGetLoginDayCount2()
    {
        try
        {
            System.out.println(this.statisticsServiceImpl.getLoginDayCount(3, 3, 3));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method under test: {@link StatisticsServiceImpl#getLoginDayCount(int, int, int)}
     */
    @Test
    void testGetLoginDayCount3()
    {
        try
        {
            System.out.println(this.statisticsServiceImpl.getLoginDayCount(2003, 13, 3));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method under test: {@link StatisticsServiceImpl#getLoginDayCount(int, int, int)}
     */
    @Test
    void testGetLoginDayCount4()
    {
        try
        {
            System.out.println(this.statisticsServiceImpl.getLoginDayCount(2003, 11, 32));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method under test: {@link StatisticsServiceImpl#getLoginMonthCount(int, int)}
     */
    @Test
    void testGetLoginMonthCount()
    {
        try
        {
            System.out.println(this.statisticsServiceImpl.getLoginMonthCount(3, 3));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method under test: {@link StatisticsServiceImpl#getLoginMonthCount(int, int)}
     */
    @Test
    void testGetLoginMonthCount2()
    {
        System.out.println(this.statisticsServiceImpl.getLoginMonthCount(2023, 4));
    }

    /**
     * Method under test: {@link StatisticsServiceImpl#getLoginDayUVCount(int, int, int)}
     */
    @Test
    void testGetLoginDayUVCount()
    {
        System.out.println(this.statisticsServiceImpl.getLoginDayUVCount(2023, 4, 4));
    }

    /**
     * Method under test: {@link StatisticsServiceImpl#getLoginMonthUVCount(int, int)}
     */
    @Test
    void testGetLoginMonthUVCount()
    {
        System.out.println(this.statisticsServiceImpl.getLoginMonthUVCount(2023, 4));
    }


    /**
     * Method under test: {@link StatisticsServiceImpl#getRegisterDayCount(int, int, int)}
     */
    @Test
    void testGetRegisterDayCount()
    {
        System.out.println(this.statisticsServiceImpl.getRegisterDayCount(2023, 4, 4));
    }


    /**
     * Method under test: {@link StatisticsServiceImpl#getRegisterMonthCount(int, int)}
     */
    @Test
    void testGetRegisterMonthCount()
    {
        System.out.println(this.statisticsServiceImpl.getRegisterMonthCount(2023, 4));
    }

}

