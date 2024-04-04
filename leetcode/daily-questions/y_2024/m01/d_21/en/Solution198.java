package y_2024.m01.d_21.en;

/**
 * <a href="https://leetcode.com/problems/house-robber/description/?envType=daily-question&envId=2024-01-21">...</a>
 */
public class Solution198 {
    /**
     * DP
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 定义 dp[i][0] 为不偷下标为 i 的房间时的最高金额
        // 定义 dp[i][1] 为偷下标为 i 的房间时的最高金额
        int[][] dp = new int[nums.length][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    /**
     * DP
     * 状态压缩
     */
    public int rob1(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
