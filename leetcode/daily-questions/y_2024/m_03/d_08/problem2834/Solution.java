package y_2024.m_03.d_08.problem2834;

/**
 * <a href="https://leetcode.cn/problems/find-the-minimum-possible-sum-of-a-beautiful-array/description/?envType=daily-question&envId=2024-03-08">...</a>
 */
public class Solution {
    public int minimumPossibleSum(int n, int k) {
        long m = Math.min(k / 2, n);
        return (int) ((m * (m + 1) + (n - m - 1 + k * 2) * (n - m)) / 2 % 1_000_000_007);
    }
}
