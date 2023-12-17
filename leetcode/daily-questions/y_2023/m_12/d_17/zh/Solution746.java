package y_2023.m_12.d_17.zh;

/**
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/?envType=daily-question&envId=2023-12-17">...</a>
 */
public class Solution746 {

    /**
     * 递归+备忘录
     * AC
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] mem = new int[1000];
        int a = cost[cost.length - 1] + minCostClimbingStairs(cost, cost.length - 1, mem);
        int b = cost[cost.length - 2] + minCostClimbingStairs(cost, cost.length - 2, mem);
        return Math.min(a, b);
    }

    public int minCostClimbingStairs(int[] cost, int index, int[] mem) {
        if (index == 0 || index == 1) return 0;
        if (mem[index] != 0) return mem[index];
        int a = cost[index - 1] + minCostClimbingStairs(cost, index - 1, mem);
        int b = cost[index - 2] + minCostClimbingStairs(cost, index - 2, mem);
        mem[index] = Math.min(a, b);
        return mem[index];
    }

    /**
     * DP
     * AC
     */
    public int minCostClimbingStairs1(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        Solution746 solution = new Solution746();
        System.out.println(solution.minCostClimbingStairs1(new int[]{10, 15, 20}));
    }
}
