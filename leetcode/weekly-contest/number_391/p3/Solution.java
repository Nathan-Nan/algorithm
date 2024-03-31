package number_391.p3;

/**
 * <a href="https://leetcode.cn/problems/count-alternating-subarrays/">...</a>
 */
public class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];
        dp[0] = 1;
        int s = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (nums[i] == nums[i - 1]) {
                s = i;
            } else {
                dp[i] += i - s;
            }
        }
        return dp[n - 1];
    }
}