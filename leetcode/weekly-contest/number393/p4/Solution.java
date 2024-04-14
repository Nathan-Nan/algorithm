package number393.p4;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-393/problems/minimum-sum-of-values-by-dividing-array/">...</a>
 */
public class Solution {
    // 记忆化搜索
    int inf = 0x3f3f3f3f;
    Map<String, Integer> cache = new HashMap<>();
    int m, n;
    int[] nums, andValues;

    public int minimumValueSum(int[] nums, int[] andValues) {
        this.n = nums.length;
        this.m = andValues.length;
        this.nums = nums;
        this.andValues = andValues;
        int ans = dfs(0, 0, -1);  // (-1)&x=x
        return ans == inf ? -1 : ans;
    }

    // 表示当前考虑到 nums[i]，已经划分了 j 段，且当前待划分的这一段已经参与 AND 运算的结果为 value
    public int dfs(int i, int j, int value) {
        if (m - j > n - i)  // 剩余元素无法划分
            return inf;
        if (j == m) {  // 0表示划分成功
            return i == n ? 0 : inf;
        }
        if (i == n)  // 剪枝：边界值判断
            return value == andValues[j] ? nums[i - 1] : inf;
        value &= nums[i];
        if (value < andValues[j])  // 剪枝：无法等于 andValues[j]
            return inf;
        String key = i + "-" + j + "-" + value;
        Integer res = cache.get(key);  // 不能用int
        if (res != null)  // 记忆化
            return res;

        res = dfs(i + 1, j, value);  // 不划分
        if (value == andValues[j]) {  // 相等，划分
            res = Math.min(res, dfs(i + 1, j + 1, -1) + nums[i]);
        }
        cache.put(key, res);
        return res;
    }
}
