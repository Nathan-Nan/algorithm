package number_384.problem1;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-384/problems/modify-the-matrix/">...</a>
 */
public class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] maxCol = new int[n];
        Arrays.fill(maxCol, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = matrix[i][j] == -1 ? maxCol[j] : matrix[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.modifiedMatrix(new int[][]{{1, 2, -1}, {4, -1, 6}, {7, 8, 9}})));
    }
}
