package y_2023.m_12.d_22.zh;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-removals-to-make-mountain-array/description/?envType=daily-question&envId=2023-12-22">...</a>
 */
public class Solution1671 {
    /**
     * 前后缀分解+最长递增（递减）子序列
     * 前缀 --> 最长递增子序列
     * 后缀 --> 最长递减子序列
     * 求：max(前缀长度 + 后缀长度)
     */
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        List<Integer> g = new ArrayList<>();
        for (int i = n - 1; i > 0; i--) {
            int x = nums[i];
            int j = lowerBound(g, x);
            if (j == g.size()) {
                g.add(x);
            } else {
                g.set(j, x);
            }
            suf[i] = j + 1; // 从 nums[i] 开始的最长严格递减子序列的长度
        }

        int mx = 0;
        g.clear();
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i];
            int j = lowerBound(g, x);
            if (j == g.size()) {
                g.add(x);
            } else {
                g.set(j, x);
            }
            int pre = j + 1; // 在 nums[i] 结束的最长严格递增子序列的长度
            if (pre >= 2 && suf[i] >= 2) {
                mx = Math.max(mx, pre + suf[i] - 1); // 减去重复的 nums[i]
            }
        }
        return n - mx;
    }

    // 请看 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(List<Integer> g, int target) {
        int left = -1, right = g.size(); // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = (left + right) >>> 1;
            if (g.get(mid) < target) {
                left = mid; // 范围缩小到 (mid, right)
            } else {
                right = mid; // 范围缩小到 (left, mid)
            }
        }
        return right; // 或者 left+1
    }
}
