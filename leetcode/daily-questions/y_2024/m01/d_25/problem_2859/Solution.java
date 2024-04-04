package y_2024.m01.d_25.problem_2859;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/sum-of-values-at-indices-with-k-set-bits/description/?envType=daily-question&envId=2024-01-25">...</a>
 */
public class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }
}
