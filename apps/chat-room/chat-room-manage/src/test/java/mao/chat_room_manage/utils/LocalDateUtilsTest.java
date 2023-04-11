package mao.chat_room_manage.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LocalDateUtilsTest
{
    /**
     * Method under test: {@link LocalDateUtils#getDayTimeDifference(LocalDate, LocalDate)}
     */
    @Test
    void testGetDayTimeDifference()
    {
        assertEquals(1L, LocalDateUtils.getDayTimeDifference(LocalDate.ofEpochDay(0L), LocalDate.ofEpochDay(1L)));
    }

    /**
     * Method under test: {@link LocalDateUtils#getMonthTimeDifference(LocalDate, LocalDate)}
     */
    @Test
    void testGetMonthTimeDifference()
    {
        assertEquals(23628L, LocalDateUtils.getMonthTimeDifference(LocalDate.ofYearDay(1, 1), LocalDate.ofEpochDay(1L)));
    }

    /**
     * Method under test: {@link LocalDateUtils#getDayTimeDifference(LocalDate, LocalDate)}
     */
    @Test
    void testGetDayTimeDifference2()
    {
        assertEquals(2L, LocalDateUtils.getDayTimeDifference(LocalDate.now().minusDays(2), LocalDate.now()));
    }

    /**
     * Method under test: {@link LocalDateUtils#getDayTimeDifference(LocalDate, LocalDate)}
     */
    @Test
    void testGetDayTimeDifference3()
    {
        assertEquals(5L, LocalDateUtils.getDayTimeDifference(LocalDate.now().minusDays(5), LocalDate.now()));
    }

    /**
     * Method under test: {@link LocalDateUtils#getDayTimeDifference(LocalDate, LocalDate)}
     */
    @Test
    void testGetDayTimeDifference4()
    {
        assertEquals(387L, LocalDateUtils.getDayTimeDifference(LocalDate.now().minusDays(387), LocalDate.now()));
    }

    /**
     * Method under test: {@link LocalDateUtils#getMonthTimeDifference(LocalDate, LocalDate)}
     */
    @Test
    void testGetMonthTimeDifference2()
    {
        assertEquals(1L, LocalDateUtils.getMonthTimeDifference(LocalDate.now().minusMonths(1), LocalDate.now()));
    }

    /**
     * Method under test: {@link LocalDateUtils#getMonthTimeDifference(LocalDate, LocalDate)}
     */
    @Test
    void testGetMonthTimeDifference3()
    {
        assertEquals(3L, LocalDateUtils.getMonthTimeDifference(LocalDate.now().minusMonths(3), LocalDate.now()));
    }

    /**
     * Method under test: {@link LocalDateUtils#getMonthTimeDifference(LocalDate, LocalDate)}
     */
    @Test
    void testGetMonthTimeDifference4()
    {
        assertEquals(287L, LocalDateUtils.getMonthTimeDifference(LocalDate.now().minusMonths(287), LocalDate.now()));
    }

    /**
     * Method under test: {@link LocalDateUtils#getMonthTimeDifference(LocalDate, LocalDate)}
     */
    @Test
    void testGetMonthTimeDifference5()
    {
        assertEquals(9L, LocalDateUtils.getMonthTimeDifference(LocalDate.now().minusMonths(9), LocalDate.now()));
    }
}

