package y_2023.m_12.d_26.en;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/description/?envType=daily-question&envId=2023-12-26">...</a>
 */
public class Solution1155 {

    private static final int MOD = 1_000_000_007;

    /**
     * DP 解法
     */
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) return 0;
        if (n == 1 || n == target) return 1;
        int[][] memo = new int[n + 1][target - n + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dfs(n, k, target - n, memo);
    }

    /**
     * @param i    骰子数量
     * @param k    骰子上面的数字最大值
     * @param j    需要凑起来的数字
     * @param memo 备忘录，避免重复计算
     * @return 方案数
     */
    private int dfs(int i, int k, int j, int[][] memo) {
        if (i == 0) {
            return j == 0 ? 1 : 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        for (int x = 0; x < k && x <= j; x++) {
            res = (res + dfs(i - 1, k, j - x, memo)) % MOD;
        }
        return memo[i][j] = res;
    }

    public static void main(String[] args) {
        Solution1155 solution = new Solution1155();
        System.out.println(solution.numRollsToTarget(1, 6, 3));
        System.out.println(solution.numRollsToTarget(2, 6, 7));
        System.out.println(solution.numRollsToTarget(30, 30, 500));
    }
}
