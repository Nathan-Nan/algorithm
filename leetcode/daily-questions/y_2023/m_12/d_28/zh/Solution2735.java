package y_2023.m_12.d_28.zh;

/**
 * <a href="https://leetcode.cn/problems/collecting-chocolates/description/?envType=daily-question&envId=2023-12-28">...</a>
 */
public class Solution2735 {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        long[] s = new long[n]; // s[k] 统计操作 k 次的总成本
        for (int i = 0; i < n; i++) {
            s[i] = (long) i * x;
        }
        for (int i = 0; i < n; i++) { // 子数组左端点
            int mn = nums[i];
            for (int j = i; j < n + i; j++) { // 子数组右端点（把数组视作环形的）
                mn = Math.min(mn, nums[j % n]); // 维护从 nums[i] 到 nums[j] 的最小值
                s[j - i] += mn; // 累加操作 j-i 次的花费
            }
        }
        long ans = Long.MAX_VALUE;
        for (long v : s) {
            ans = Math.min(ans, v);
        }
        return ans;
    }
}
