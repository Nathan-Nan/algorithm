package y_2024.m_03.d_20.problem1969;

/**
 * <a href="https://leetcode.cn/problems/minimum-non-zero-product-of-the-array-elements/description/?envType=daily-question&envId=2024-03-20">...</a>
 */
public class Solution {
    private static final int MOD = 1_000_000_007;

    private long pow(long x, int p) {
        x %= MOD;
        long res = 1;
        while (p-- > 0) {
            res = res * x % MOD;
            x = x * x % MOD;
        }
        return res;
    }

    public int minNonZeroProduct(int p) {
        long k = (1L << p) - 1;
        return (int) (k % MOD * pow(k - 1, p - 1) % MOD);
    }
}
