package y_2024.m03.d_25.problem518;

/**
 * <a href="https://leetcode.cn/problems/coin-change-ii/description/?envType=daily-question&envId=2024-03-25">...</a>
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int x : coins) {
            for (int c = x; c <= amount; c++) {
                f[c] += f[c - x];
            }
        }
        return f[amount];
    }
}
