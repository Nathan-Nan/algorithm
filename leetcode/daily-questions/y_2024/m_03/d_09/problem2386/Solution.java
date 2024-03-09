package y_2024.m_03.d_09.problem2386;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-the-k-sum-of-an-array/description/?envType=daily-question&envId=Invalid%20Date">...</a>
 */
public class Solution {
    /**
     * 题解参考：{@link <a href="https://leetcode.cn/problems/find-the-k-sum-of-an-array/solutions/1764389/zhuan-huan-dui-by-endlesscheng-8yiq/?envType=daily-question&envId=Invalid%20Date">...</a>}
     */
    public long kSum(int[] nums, int k) {
        long sum = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                nums[i] = -nums[i];
            }
            right += nums[i];
        }
        Arrays.sort(nums);

        long left = -1;
        while (left + 1 < right) { // 开区间二分，原理见【前置知识】
            long mid = (left + right) / 2;
            cnt = k - 1; // 空子序列算一个
            dfs(0, mid, nums);
            if (cnt == 0) { // 找到 k 个元素和不超过 mid 的子序列
                right = mid;
            } else {
                left = mid;
            }
        }
        return sum - right;
    }

    private int cnt;

    // 反向递归，增加改成减少，这样可以少传一些参数
    private void dfs(int i, long s, int[] nums) {
        if (cnt == 0 || i == nums.length || s < nums[i]) {
            return;
        }
        cnt--;
        dfs(i + 1, s - nums[i], nums); // 选
        dfs(i + 1, s, nums); // 不选
    }
}
