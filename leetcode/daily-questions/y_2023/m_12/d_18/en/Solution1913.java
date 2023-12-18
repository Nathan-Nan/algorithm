package y_2023.m_12.d_18.en;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/?envType=daily-question&envId=2023-12-18">...</a>
 */
public class Solution1913 {
    /**
     * 解法一：排序
     */
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }

    /**
     * 解法二：遍历找出最大、次大、最小、次小的数
     */
    public int maxProductDifference1(int[] nums) {
        int max = Integer.MIN_VALUE, max1 = Integer.MIN_VALUE, min = Integer.MAX_VALUE, min1 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num >= max) {
                max1 = max;
                max = num;
            } else if (num > max1)
                max1 = num;

            if (num <= min) {
                min1 = min;
                min = num;
            } else if (num < min1)
                min1 = num;
        }
        return (max * max1) - (min * min1);

    }
}
