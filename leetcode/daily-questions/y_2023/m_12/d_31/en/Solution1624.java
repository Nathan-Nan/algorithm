package y_2023.m_12.d_31.en;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/?envType=daily-question&envId=2023-12-31">...</a>
 */
public class Solution1624 {
    /**
     * 暴力解法
     * O(n^2)
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length(), ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    ans = Math.max(ans, j - i - 1);
                }
            }
        }
        return ans;
    }

    /**
     * 优化解法
     * O(n)
     */
    public int maxLengthBetweenEqualCharacters1(String s) {
        int n = s.length(), ans = -1;
        int[] first = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (first[c - 'a'] == -1) {
                first[c - 'a'] = i;
            } else {
                ans = Math.max(ans, i - first[c - 'a'] - 1);
            }
        }
        return ans;
    }
}
