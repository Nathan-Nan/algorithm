package double_weekly.number124.problem_4;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-124/problems/maximize-consecutive-elements-in-an-array-after-modification/">...</a>
 */
public class Solution {
    public int maxSelectedElements(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int[][] dp = new int[len][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int ret = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + 1);
            } else if (nums[i] == nums[i - 1] + 1) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0] + 1);
                dp[i][1] = dp[i - 1][1] + 1;
            } else if (nums[i] == nums[i - 1] + 2) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = 1;
            } else {
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
            ret = Math.max(ret, Math.max(dp[i][0], dp[i][1]));
        }
        return ret;
    }
}
