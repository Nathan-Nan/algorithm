package y_2023.m_11.d_24.en;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-coins-you-can-get/?envType=daily-question&envId=2023-11-24">...</a>
 * <p>
 * Medium
 */
public class Solution1561 {

    /**
     * 贪心 + 双指针
     * <p>
     * 每次取走第二多的堆
     */
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0, r = piles.length - 2, n = piles.length / 3;
        for (int l = 0; l < n; l++) {
            ans += piles[r];
            r -= 2;
        }
        return ans;
    }
}
