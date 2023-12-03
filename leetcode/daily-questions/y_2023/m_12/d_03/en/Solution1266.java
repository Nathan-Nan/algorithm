package y_2023.m_12.d_03.en;

/**
 * <a href="https://leetcode.cn/problems/minimum-time-visiting-all-points/description/">...</a>
 */
public class Solution1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] cur = points[i];
            int[] next = points[i + 1];
            int diffX = Math.abs(next[0] - cur[0]);
            int diffY = Math.abs(next[1] - cur[1]);
            ans += Math.max(diffX, diffY);
        }
        return ans;
    }
}
