package double_weekly.number126.problem_4;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-126/problems/find-the-sum-of-the-power-of-all-subsequences/">...</a>
 */
public class Solution {
    public int sumOfPower(int[] nums, int k) {
        long[] cou = new long[k + 1];
        cou[0] = 1L;
        int n = nums.length;
        long mod = 1000000007;
        for (int i = 0; i < n; i++) {
            long[] ncou = new long[k + 1];
            for (int t1 = 0; t1 <= k && t1 < nums[i]; t1++) {
                ncou[t1] = 2 * cou[t1];
                ncou[t1] %= mod;
            }
            for (int t1 = nums[i]; t1 <= k; t1++) {
                ncou[t1] = cou[t1] * 2 + cou[t1 - nums[i]];
                ncou[t1] %= mod;
            }
            cou = ncou;
        }
        return (int) cou[k];
    }
}
