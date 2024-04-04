package y_2024.m03.d_15.problem2312;

/**
 * <a href="https://leetcode.cn/problems/selling-pieces-of-wood/description/?envType=daily-question&envId=2024-03-15">...</a>
 */
public class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] f = new long[m + 1][n + 1];
        for (int[] p : prices) {
            f[p[0]][p[1]] = p[2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= j / 2; k++) f[i][j] = Math.max(f[i][j], f[i][k] + f[i][j - k]); // 垂直切割
                for (int k = 1; k <= i / 2; k++) f[i][j] = Math.max(f[i][j], f[k][j] + f[i - k][j]); // 水平切割
            }
        }
        return f[m][n];
    }
}
