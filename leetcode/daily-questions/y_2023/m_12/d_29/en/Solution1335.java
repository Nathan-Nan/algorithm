package y_2023.m_12.d_29.en;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/description/?envType=daily-question&envId=2023-12-29">...</a>
 */
public class Solution1335 {
    /**
     * DP
     */
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) return -1;
        if (jobDifficulty.length == d) return Arrays.stream(jobDifficulty).sum();
        int n = jobDifficulty.length;
        int[][] dp = new int[d][n];
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], jobDifficulty[i]);
        }
        for (int i = 1; i < d; i++) {
            for (int j = n - 1; j >= i; j--) {
                dp[i][j] = Integer.MAX_VALUE;
                int max = 0;
                for (int k = j; k >= i; k--) {
                    max = Math.max(jobDifficulty[k], max);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + max);
                }
            }

        }
        return dp[d - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution1335 solution = new Solution1335();
        System.out.println(solution.minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
        System.out.println(solution.minDifficulty(new int[]{9, 9, 9}, 4));
        System.out.println(solution.minDifficulty(new int[]{1, 1, 1}, 3));
        System.out.println(solution.minDifficulty(new int[]{7, 1, 7, 1, 7, 1}, 3));
        System.out.println(solution.minDifficulty(new int[]{11, 111, 22, 222, 33, 333, 44, 444}, 6));
    }
}
