package en;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimize-maximum-pair-sum-in-array/description/">...</a>
 */
public class Solution1877 {
    /**
     * 贪心解法，ac
     */
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n / 2; i++) {
            ans = Math.max(ans, nums[i] + nums[n - i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1877 solution = new Solution1877();
        System.out.println(solution.minPairSum(new int[]{3, 5, 2, 3}));
        System.out.println(solution.minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
    }
}
