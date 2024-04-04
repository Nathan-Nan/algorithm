package y_2024.m01.d_22.en;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/set-mismatch/description/?envType=daily-question&envId=2024-01-22">...</a>
 */
public class Solution645 {
    /**
     * 统计每个数出现的次数，找出次数分别为 2 和 0 的数
     */
    public int[] findErrorNums(int[] nums) {
        int dup = -1, mis = -1, n = nums.length;
        int[] freq = new int[n + 1];
        for (int num : nums) {
            freq[num]++;
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                mis = i;
            }
            if (freq[i] == 2) {
                dup = i;
            }
        }
        return new int[]{dup, mis};
    }

    /**
     * Java Stream API implementation
     */
    public int[] findErrorNums1(int[] nums) {
        return new int[]{Arrays.stream(nums).sum() - Arrays.stream(nums).distinct().sum(), (1 + nums.length) * nums.length / 2 - Arrays.stream(nums).distinct().sum()};
    }

    public static void main(String[] args) {
        Solution645 solution = new Solution645();
        System.out.println(Arrays.toString(solution.findErrorNums1(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(solution.findErrorNums1(new int[]{1, 1})));
        System.out.println(Arrays.toString(solution.findErrorNums1(new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.findErrorNums1(new int[]{3, 2, 2})));
        System.out.println(Arrays.toString(solution.findErrorNums1(new int[]{3, 2, 3, 4, 6, 5})));
    }
}
