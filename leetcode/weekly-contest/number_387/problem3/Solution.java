package number_387.problem3;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-387/problems/minimum-operations-to-write-the-letter-y-on-a-grid/">...</a>
 */
public class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int[][] counts = new int[3][2];
        int n = grid.length;
        int center = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (inY(i, j, center)) {
                    counts[grid[i][j]][0]++;
                } else {
                    counts[grid[i][j]][1]++;
                }
            }
        }
        int ans = n * n;
        for (int i = 0; i < 3; i++) {
            int sumY = counts[0][0] + counts[1][0] + counts[2][0] - counts[i][0];
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                int sumNoY = counts[0][1] + counts[1][1] + counts[2][1] - counts[j][1];
                ans = Math.min(ans, sumNoY + sumY);
            }
        }
        return ans;
    }

    private boolean inY(int x, int y, int center) {
        return x >= center ? y == center : x == y || Math.abs(x - center) == Math.abs(y - center) && y >= center;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumOperationsToWriteY(new int[][]{{1, 2, 2}, {1, 1, 0}, {0, 1, 0}}));
    }
}
