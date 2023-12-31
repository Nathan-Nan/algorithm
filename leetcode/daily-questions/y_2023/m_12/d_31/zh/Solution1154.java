package y_2023.m_12.d_31.zh;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * <a href="https://leetcode.cn/problems/day-of-the-year/description/?envType=daily-question&envId=2023-12-31">...</a>
 */
public class Solution1154 {

    /**
     * JDK-API
     * {@link java.time.LocalDate}
     * {@link java.time.format.DateTimeFormatter}
     * {@link java.time.format.DateTimeFormatterBuilder}
     */
    public int dayOfYear(String date) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd").toFormatter();
        return LocalDate.parse(date, formatter).getDayOfYear();
    }

    static final int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    /**
     * 数学计算
     */
    public int dayOfYear1(String date) {
        int y = date.charAt(0) * 1000 + date.charAt(1) * 100 + date.charAt(2) * 10 + date.charAt(3) - 53328;
        int m = date.charAt(5) * 10 + date.charAt(6) - 529;
        int res = days[m] + date.charAt(8) * 10 + date.charAt(9) - 528;
        if ((y & 3) == 0 && m > 1) {
            ++res;
            if ((y % 100) == 0 && y % 400 != 0) --res;
        }
        return res;

    }
}
