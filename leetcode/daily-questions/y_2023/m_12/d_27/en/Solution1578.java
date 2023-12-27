package y_2023.m_12.d_27.en;

/**
 * <a href="https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/?envType=daily-question&envId=2023-12-27">...</a>
 */
public class Solution1578 {
    /**
     * 贪心
     */
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        if (n == 1) return 0;
        int ans = 0;
        for (int i = 0; i < n; ) {
            int max = Integer.MIN_VALUE;
            char c = colors.charAt(i);
            while (i < n && c == colors.charAt(i)) {
                ans += neededTime[i];
                max = Math.max(max, neededTime[i]);
                i++;
            }
            ans -= max;
        }

        return ans;
    }
}
