package y_2024.m_01.d_01.zh;

/**
 * <a href="https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/description/?envType=daily-question&envId=2024-01-01">...</a>
 */
public class Solution1599 {

    /**
     * 数学模拟解法
     */
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int wait = 0, profit = 0, operateCnt = 0, board = 0;
        int[] ans = {0, -1};
        for (int i = 0; i < customers.length || wait != 0; i++) {
            if (i < customers.length) {
                wait += customers[i];
            }
            board += Math.min(wait, 4);
            wait = Math.max(wait - 4, 0);
            operateCnt++;
            profit = board * boardingCost - operateCnt * runningCost;
            if (profit > ans[0]) {
                ans[0] = profit;
                ans[1] = operateCnt;
            }
        }

        return ans[1];
    }

    public static void main(String[] args) {
        Solution1599 solution = new Solution1599();
        System.out.println(solution.minOperationsMaxProfit(new int[]{8, 3}, 5, 6));
        System.out.println(solution.minOperationsMaxProfit(new int[]{10, 9, 6}, 6, 4));
        System.out.println(solution.minOperationsMaxProfit(new int[]{3, 4, 0, 5, 1}, 1, 92));
        System.out.println(solution.minOperationsMaxProfit(new int[]{10, 10, 6, 4, 7}, 3, 8));
    }

}
