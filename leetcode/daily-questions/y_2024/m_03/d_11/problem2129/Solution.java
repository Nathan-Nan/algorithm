package y_2024.m_03.d_11.problem2129;

/**
 * <a href="https://leetcode.cn/problems/capitalize-the-title/description/?envType=daily-question&envId=2024-03-11">...</a>
 */
public class Solution {
    public String capitalizeTitle(String title) {
        StringBuilder ans = new StringBuilder();
        for (String s : title.split(" ")) {
            if (ans.length() > 0) {
                ans.append(' ');
            }
            if (s.length() > 2) {
                ans.append(s.substring(0, 1).toUpperCase()); // 首字母大写
                s = s.substring(1);
            }
            ans.append(s.toLowerCase());
        }
        return ans.toString();
    }
}
