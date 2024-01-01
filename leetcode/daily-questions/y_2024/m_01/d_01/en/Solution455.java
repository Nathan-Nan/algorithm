package y_2024.m_01.d_01.en;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/assign-cookies/description/?envType=daily-question&envId=2024-01-01">...</a>
 */
public class Solution455 {
    /**
     * 双指针解法
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0, i = 0, j = 0, m = g.length, n = s.length;
        while (i < m && j < n) {
            while (j < n && s[j] < g[i]) {
                j++;
            }
            if (j < n) {
                ans++;
                i++;
                j++;
            }
        }
        return ans;
    }

    /**
     * 优化解法
     */
    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0, m = g.length;

        for (int x : s) {
            if (ans >= m) {
                break;
            }
            if (x >= g[ans]) {
                ans++;
            }
        }
        return ans;
    }
}
