package y_2024.m03.d_16.problem2684;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-moves-in-a-grid/description/?envType=daily-question&envId=2024-03-16">...</a>
 */
public class Solution {
    private int ans;

    public int maxMoves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(i, 0, grid); // 从第一列的任一单元格出发
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] grid) {
        ans = Math.max(ans, j);
        if (ans == grid[0].length - 1) { // ans 已达到最大值
            return;
        }
        // 向右上/右/右下走一步
        for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, grid.length); k++) {
            if (grid[k][j + 1] > grid[i][j]) {
                dfs(k, j + 1, grid);
            }
        }
        grid[i][j] = 0;
    }
}
