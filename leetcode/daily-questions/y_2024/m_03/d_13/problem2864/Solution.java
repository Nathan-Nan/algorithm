package y_2024.m_03.d_13.problem2864;

/**
 * <a href="https://leetcode.cn/problems/maximum-odd-binary-number/description/?envType=daily-question&envId=2024-03-13">...</a>
 */
public class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cnt1 = (int) s.chars().filter(c -> c == '1').count();
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < cnt1; i++) {
            ans.append(1);
        }
        for (int i = 0; i < s.length() - cnt1; i++) {
            ans.append(0);
        }
        ans.append(1);

        return ans.toString();
    }
}
