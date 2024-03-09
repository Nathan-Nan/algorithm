package y_2024.m_03.d_07.problem2575;

/**
 * <a href="https://leetcode.cn/problems/find-the-divisibility-array-of-a-string/description/?envType=daily-question&envId=2024-03-07">...</a>
 */
public class Solution {
    public int[] divisibilityArray(String word, int m) {
        char[] s = word.toCharArray();
        int[] ans = new int[s.length];
        long x = 0;
        for (int i = 0; i < s.length; i++) {
            x = (x * 10 + (s[i] - '0')) % m;
            if (x == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }
}
