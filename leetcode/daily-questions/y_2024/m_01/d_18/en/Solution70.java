package y_2024.m_01.d_18.en;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/description/?envType=daily-question&envId=2024-01-18">...</a>
 */
public class Solution70 {
    private final int[] mem = new int[46];

    /**
     * 递归
     */
    public int climbStairs(int n) {
        if (mem[n] != 0) return mem[n];
        if (n < 4) {
            mem[n] = n;
        } else {
            mem[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }
        return mem[n];
    }

    /**
     * 递推
     */
    public int climbStairs1(int n) {
        if (n < 4) {
            return n;
        }
        int a = 1, b = 1, sum;
        for (int i = 0; i < n - 1; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
