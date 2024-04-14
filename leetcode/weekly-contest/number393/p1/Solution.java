package number393.p1;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-393/problems/latest-time-you-can-obtain-after-replacing-characters/">...</a>
 */
public class Solution {
    public String findLatestTime(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '?') {
            chars[0] = chars[1] != '?' && chars[1] > '1' ? '0' : '1';
        }
        if (chars[1] == '?') {
            chars[1] = chars[0] == '0' ? '9' : '1';
        }
        if (chars[3] == '?') {
            chars[3] = '5';
        }
        if (chars[4] == '?') {
            chars[4] = '9';
        }

        return new String(chars);
    }
}
