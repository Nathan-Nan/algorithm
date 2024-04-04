package y_2024.m01.d_23.zh;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-alternating-subarray/description/?envType=daily-question&envId=2024-01-23">...</a>
 */
public class Solution2765 {

    /**
     * 解法一：暴力解法，O(n ^ 3)
     * AC
     */
    public int alternatingSubarray1(int[] nums) {
        int maxLength = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(nums, i, j)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    private boolean check(int[] nums, int start, int end) {
        int last = -1;
        for (int i = start; i < end; i++) {
            int sub = nums[i + 1] - nums[i];
            if ((sub != 1 && sub != -1) || sub == last) {
                return false;
            }
            last *= -1;
        }
        return true;
    }

    /**
     * 解法二：DP，O(n)
     * AC
     */
    public int alternatingSubarray(int[] nums) {
        int maxLength = -1, n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] == ((dp[i - 1] & 1) == 1 ? 1 : -1)) {
                dp[i] = dp[i - 1] + 1;
            } else if (nums[i] - nums[i - 1] == 1) {
                dp[i] = 2;
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength == 1 ? -1 : maxLength;
    }

    /**
     * 解法三：分组循环，O(n)
     * AC
     */
    public int alternatingSubarray2(int[] nums) {
        int ans = -1, i = 0, n = nums.length;
        while (i < n - 1) {
            if (nums[i + 1] - nums[i] != 1) {
                i++; // 直接跳过
                continue;
            }
            int i0 = i; // 记录这一组的开始位置
            i += 2; // i 和 i+1 已经满足要求，从 i+2 开始判断
            while (i < n && nums[i] == nums[i - 2]) {
                i++;
            }
            // 从 i0 到 i-1 是满足题目要求的（并且无法再延长的）子数组
            ans = Math.max(ans, i - i0);
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2765 solution = new Solution2765();
        // System.out.println(solution.alternatingSubarray(new int[]{2, 3, 4, 3, 4}));
        // System.out.println(solution.alternatingSubarray(new int[]{4, 5, 6}));
        // System.out.println(solution.alternatingSubarray(new int[]{21, 9, 5}));
        System.out.println(solution.alternatingSubarray2(new int[]{21, 9, 21}));
    }
}
