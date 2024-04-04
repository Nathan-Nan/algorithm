package y_2024.m03.d_14.problem2789;

/**
 * <a href="https://leetcode.cn/problems/largest-element-in-an-array-after-merge-operations/description/?envType=daily-question&envId=2024-03-14">...</a>
 */
public class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long sum = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum = nums[i] <= sum ? sum + nums[i] : nums[i];
        }
        return sum;
    }
}
