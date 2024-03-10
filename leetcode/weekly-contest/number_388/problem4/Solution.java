package number_388.problem4;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-388/problems/maximum-strength-of-k-disjoint-subarrays/">...</a>
 */
public class Solution {
    int n;
    int[] nums;
    long[][][] memo;

    public long maximumStrength(int[] _nums, int k) {
        nums = _nums;
        n = nums.length;
        memo = new long[n + 1][k + 1][2];
        for (int i = 0; i < memo.length; i++) {
            for (int i1 = 0; i1 < memo[i].length; i1++) {
                Arrays.fill(memo[i][i1], -1);
            }
        }
        return dfs(0, k, 0);
    }

    private long dfs(int idx, int k, int lastk) {
        if (idx == n || (k == 0 && lastk == 0)) return 0;
        if (memo[idx][k][lastk] != -1) return memo[idx][k][lastk];
        long res = Long.MIN_VALUE;
        if (n - idx - 1 >= k) res = Math.max(res, dfs(idx + 1, k, 0)); // bu选
        // xuan
        if (k > 0) res = Math.max(res, dfs(idx + 1, k - 1, 1) + (long) nums[idx] * (k % 2 == 0 ? -1 : 1) * k);
        if (lastk == 1 && n - idx - 1 >= k) {
            res = Math.max(res, dfs(idx + 1, k, 1) + (long) nums[idx] * ((k + 1) % 2 == 0 ? -1 : 1) * (k + 1));
        }
        return memo[idx][k][lastk] = res;
    }
}
