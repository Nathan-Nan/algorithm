package y_2024.m_03.d_24.problem322;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/description/?envType=daily-question&envId=2024-03-24">...</a>
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2); // 除 2 是防止下面 + 1 溢出
        f[0] = 0;
        for (int x : coins)
            for (int c = x; c <= amount; ++c)
                f[c] = Math.min(f[c], f[c - x] + 1);
        int ans = f[amount];
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }
}
