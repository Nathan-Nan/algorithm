package y_2024.m03.d_29.problem2908;

/**
 * <a href="https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-i/description/?envType=daily-question&envId=2024-03-29">...</a>
 */
public class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n]; // 后缀最小值
        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i > 1; i--) {
            suf[i] = Math.min(suf[i + 1], nums[i]);
        }

        int ans = Integer.MAX_VALUE;
        int pre = nums[0]; // 前缀最小值
        for (int j = 1; j < n - 1; j++) {
            if (pre < nums[j] && nums[j] > suf[j + 1]) { // 山形
                ans = Math.min(ans, pre + nums[j] + suf[j + 1]); // 更新答案
            }
            pre = Math.min(pre, nums[j]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}