package y_2023.m_12.d_30.zh;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * <a href="https://leetcode.cn/problems/day-of-the-week/?envType=daily-question&envId=Invalid%20Date">...</a>
 */
public class Solution1185 {
    String[] weeks = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    /**
     * 直接调用 API：{@link java.time.LocalDate}
     */
    public String dayOfTheWeek(int day, int month, int year) {
        return weeks[LocalDate.of(year, month, day).getDayOfWeek().getValue() - 1];
    }

    private static final Calendar calendar = Calendar.getInstance();
    private static final SimpleDateFormat weekFormat = new SimpleDateFormat("EEEE");

    /**
     * 直接调用 API：{@link java.util.Calendar}
     */
    public String dayOfTheWeek1(int day, int month, int year) {
        calendar.set(year, month - 1, day);
        return weekFormat.format(calendar.getTime());
    }
}
