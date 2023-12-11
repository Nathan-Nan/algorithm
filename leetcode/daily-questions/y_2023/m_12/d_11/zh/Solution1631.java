package y_2023.m_12.d_11.zh;

/**
 * <a href="https://leetcode.cn/problems/path-with-minimum-effort/description/?envType=daily-question&envId=2023-12-11">...</a>
 * 图论，求最短路径
 */
public class Solution1631 {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int rows;
    int cols;

    /**
     * 二分 + DFS
     */
    public int minimumEffortPath(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        int left = 0;
        int right = 1000000;
        while (left < right) {
            int mid = (right + left) / 2;
            // 更新左右边界
            if (dfs(heights, 0, 0, mid, new boolean[rows][cols])) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // dfs寻找是否存在一条连通左上角和右下角结点的道路
    public Boolean dfs(int[][] heights, int row, int col, int mid, boolean[][] visited) {
        if (row == rows - 1 && col == cols - 1) {
            return true;
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol] &&
                    Math.abs(heights[newRow][newCol] - heights[row][col]) <= mid) {
                if (dfs(heights, newRow, newCol, mid, visited)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1631 solution = new Solution1631();
        // System.out.println(solution.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
        // System.out.println(solution.minimumEffortPath(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));
        // System.out.println(solution.minimumEffortPath(new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}}));
        System.out.println(solution.minimumEffortPath(new int[][]{{1, 10, 6, 7, 9, 10, 4, 9}}));
    }
}
