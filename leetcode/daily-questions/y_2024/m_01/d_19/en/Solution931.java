package y_2024.m_01.d_19.en;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-falling-path-sum/description/?envType=daily-question&envId=2024-01-19">...</a>
 */
public class Solution931 {
    private int[][] matrix, memo;

    /**
     * DP + 记忆化搜索
     * 参考题解：<a href="https://leetcode.cn/problems/minimum-falling-path-sum/solutions/2341851/cong-di-gui-dao-di-tui-jiao-ni-yi-bu-bu-2cwkb/">...</a>
     */
    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        int n = matrix.length;
        memo = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], Integer.MIN_VALUE);

        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++)
            ans = Math.min(ans, dfs(n - 1, c));
        return ans;
    }

    private int dfs(int r, int c) {
        if (c < 0 || c >= matrix.length) return Integer.MAX_VALUE; // 出界
        if (r == 0) return matrix[0][c]; // 到达第一行
        if (memo[r][c] != Integer.MIN_VALUE) return memo[r][c]; // 之前算过了
        return memo[r][c] = Math.min(Math.min(
                dfs(r - 1, c - 1), dfs(r - 1, c)), dfs(r - 1, c + 1)) + matrix[r][c];
    }
}
