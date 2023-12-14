package y_2023.m_12.d_14.en;

/**
 * <a href="https://leetcode.cn/problems/difference-between-ones-and-zeros-in-row-and-column/description/">...</a>
 */
public class Solution2482 {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length, total = m + n;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }
        int[][] diffs = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diffs[i][j] = (rows[i] + cols[j]) * 2 - total;
            }
        }

        return diffs;
    }
}
