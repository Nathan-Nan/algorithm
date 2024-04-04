package y_2024.m01.d_05.en;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=daily-question&envId=2024-01-05">...</a>
 */
public class Solution300 {
    /**
     * DP
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * DP + 二分
     * 将原问题转化为求最长递增子数组
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums.length < 2) return nums.length;
        // 维护一个 tails 数组，tails[k] 表示长度为 k + 1 的递增子序列最后一个元素
        int[] tails = new int[nums.length];
        int ans = 0;
        for (int num : nums) {
            int i = 0, j = ans;
            while (i < j) {
                int mid = i + (j - i) / 2;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (ans == j) ans++;
        }
        return ans;
    }
}
