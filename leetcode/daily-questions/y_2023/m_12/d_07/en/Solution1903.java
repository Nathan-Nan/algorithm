package y_2023.m_12.d_07.en;

/**
 * <a href="https://leetcode.cn/problems/largest-odd-number-in-string/description/">...</a>
 */
public class Solution1903 {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
