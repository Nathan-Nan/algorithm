package double_weekly.number125.problem1;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-125/problems/minimum-operations-to-exceed-threshold-value-i/">...</a>
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int num : nums) {
            if (num < k) {
                ans++;
            }
        }
        return ans;
    }
}
