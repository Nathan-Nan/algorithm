package y_2024.m03.d_30.problem2952;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-coins-to-be-added/description/?envType=daily-question&envId=2024-03-30">...</a>
 */
public class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int ans = 0, s = 1, i = 0;
        while (s <= target) {
            if (i < coins.length && coins[i] <= s) {
                s += coins[i++];
            } else {
                s *= 2; // 必须添加 s
                ans++;
            }
        }
        return ans;
    }
}
