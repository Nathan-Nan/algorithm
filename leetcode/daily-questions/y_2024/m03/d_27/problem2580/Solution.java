package y_2024.m03.d_27.problem2580;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/count-ways-to-group-overlapping-ranges/description/?envType=daily-question&envId=2024-03-27">...</a>
 */
public class Solution {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int ans = 1;
        int maxR = -1;
        for (int[] p : ranges) {
            if (p[0] > maxR) { // 无法合并
                ans = ans * 2 % 1_000_000_007; // 新区间
            }
            maxR = Math.max(maxR, p[1]); // 合并
        }
        return ans;
    }
}
