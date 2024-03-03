package number_387.problem2;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-387/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/">...</a>
 */
public class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] sums = new long[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sums[i][j] += grid[i][j];
                if (i - 1 >= 0) {
                    sums[i][j] += sums[i - 1][j];
                }
                if (j - 1 >= 0) {
                    sums[i][j] += sums[i][j - 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    sums[i][j] -= sums[i - 1][j - 1];
                }
                if (sums[i][j] <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubmatrices(new int[][]{{7, 6, 3}, {6, 6, 1}}, 18));
        System.out.println(solution.countSubmatrices(new int[][]{{7, 2, 9}, {1, 5, 0}, {2, 6, 6}}, 20));
    }
}
