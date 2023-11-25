package en;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/?envType=daily-question&envId=2023-11-25">...</a>
 */
public class Solution1685 {

    /**
     * 暴力解法，超时
     */
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                res[i] += Math.abs(nums[i] - nums[j]);
            }
        }
        return res;
    }

    /**
     * 前缀和，AC
     */
    public int[] getSumAbsoluteDifferences1(int[] nums) {
        int len = nums.length;
        int[] prefixSums = new int[len];
        prefixSums[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left_sum = i - 1 >= 0 ? nums[i] * i - prefixSums[i - 1] : 0;
            int right_sum = i + 1 < len ? prefixSums[len - 1] - prefixSums[i] - nums[i] * (len - 1 - i) : 0;
            res[i] = left_sum + right_sum;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1685 solution = new Solution1685();
        System.out.println(Arrays.toString(solution.getSumAbsoluteDifferences1(new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(solution.getSumAbsoluteDifferences1(new int[]{1, 4, 6, 8, 10})));
    }
}
