package y_2023.m_12.d_12.en;

/**
 * <a href="https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/description/">...</a>
 */
public class Solution1464 {

    /**
     * 双重循环
     * 时间复杂度 O(n^2)
     */
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j != i && j < nums.length; j++) {
                ans = Math.max(ans, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return ans;
    }

    /**
     * 一重循环
     * 时间复杂度 O(n)
     */
    public int maxProduct1(int[] nums) {
        int first = 0, second = 0;
        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }
        return (first - 1) * (second - 1);
    }
}
