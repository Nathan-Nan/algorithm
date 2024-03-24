package y_2024.m_03.d_19.problem1793;

/**
 * <a href="https://leetcode.cn/problems/maximum-score-of-a-good-subarray/description/?envType=daily-question&envId=2024-03-19">...</a>
 */
public class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int ans = nums[k];
        int minH = nums[k];
        int i = k;
        int j = k;
        for (int t = 0; t < n - 1; t++) {
            if (j == n - 1 || (i > 0 && nums[i - 1] > nums[j + 1])) {
                minH = Math.min(minH, nums[--i]);
            } else {
                minH = Math.min(minH, nums[++j]);
            }
            ans = Math.max(ans, minH * (j - i + 1));
        }
        return ans;
    }
}
