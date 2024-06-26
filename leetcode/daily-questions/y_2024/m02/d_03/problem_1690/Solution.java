package y_2024.m02.d_03.problem_1690;

/**
 * <a href="https://leetcode.cn/problems/stone-game-vii/?envType=daily-question&envId=2024-02-03">...</a>
 */
public class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] += s[i] + stones[i];
        }
        int[] f = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[j] = Math.max(s[j + 1] - s[i + 1] - f[j], s[j] - s[i] - f[j - 1]);
            }
        }
        return f[n - 1];
    }
}
