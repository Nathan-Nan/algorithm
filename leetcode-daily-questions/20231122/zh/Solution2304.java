package zh;

/**
 * <a href="https://leetcode.cn/problems/minimum-path-cost-in-a-grid/description/?envType=daily-question&envId=2023-11-22">...</a>
 */
public class Solution2304 {
    /**
     * 从上往下递推
     */
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int ans = Integer.MAX_VALUE, m = grid.length, n = grid[0].length;
        int[][] paths = new int[m][n];
        paths[0] = grid[0];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                paths[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    paths[i][j] = Math.min(paths[i][j], paths[i - 1][k] + grid[i][j] + moveCost[grid[i - 1][k]][j]);
                }
            }
        }
        for (int cost : paths[m - 1]) {
            ans = Math.min(ans, cost);
        }

        return ans;
    }

    /**
     * DP，会超时
     */
    public int minPathCost1(int[][] grid, int[][] moveCost) {
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < grid[0].length; j++) { // 枚举起点
            ans = Math.min(ans, dfs(0, j, grid, moveCost));
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] grid, int[][] moveCost) {
        if (i == grid.length - 1) { // 递归边界
            return grid[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < grid[0].length; k++) { // 移动到下一行的第 k 列
            res = Math.min(res, dfs(i + 1, k, grid, moveCost) + moveCost[grid[i][j]][k]);
        }
        return res + grid[i][j];
    }

    /**
     * DP + 记忆化搜索
     */
    public int minPathCost2(int[][] grid, int[][] moveCost) {
        int ans = Integer.MAX_VALUE;
        int[][] memo = new int[grid.length][grid[0].length];
        for (int j = 0; j < grid[0].length; j++) { // 枚举起点
            ans = Math.min(ans, dfs(0, j, memo, grid, moveCost));
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] memo, int[][] grid, int[][] moveCost) {
        if (i == grid.length - 1) { // 递归边界
            return grid[i][j];
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < grid[0].length; k++) { // 移动到下一行的第 k 列
            res = Math.min(res, dfs(i + 1, k, memo, grid, moveCost) + moveCost[grid[i][j]][k]);
        }
        memo[i][j] = res + grid[i][j];
        return memo[i][j];
    }

    public static void main(String[] args) {
        Solution2304 solution = new Solution2304();
        System.out.println(solution.minPathCost(new int[][]{{5, 3}, {4, 0}, {2, 1}}, new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}}));
    }
}
