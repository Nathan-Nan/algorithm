package ch;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/?envType=daily-question&envId=2023-11-20">...</a>
 */
public class Solution53 {
    /**
     * DP
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * DP，状态压缩
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }
}
