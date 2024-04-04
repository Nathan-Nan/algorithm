package y_2024.m03.d_18.problem303;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-immutable/description/?envType=daily-question&envId=2024-03-18">...</a>
 */
public class NumArray {
    private int[] s;

    public NumArray(int[] nums) {
        s = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            s[i + 1] = s[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }
}