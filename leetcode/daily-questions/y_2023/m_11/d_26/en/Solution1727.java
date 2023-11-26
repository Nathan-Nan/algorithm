package y_2023.m_11.d_26.en;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/largest-submatrix-with-rearrangements/description/">...</a>
 */
public class Solution1727 {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 对 matrix 做预处理，matrix[i][j] 统计有几个连续的 1，包括自己
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, row[j] * (n - j));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1727 solution = new Solution1727();
        System.out.println(solution.largestSubmatrix(new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 0, 1}}));
        System.out.println(solution.largestSubmatrix(new int[][]{{1, 0, 1, 0, 1}}));
        System.out.println(solution.largestSubmatrix(new int[][]{{1, 1, 0}, {1, 0, 1}}));
        System.out.println(solution.largestSubmatrix(new int[][]{{0, 0}, {0, 0}}));
    }
}
