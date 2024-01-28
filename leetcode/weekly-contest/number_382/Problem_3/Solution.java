package number_382.Problem_3;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-382/problems/alice-and-bob-playing-flower-game/">...</a>
 */
public class Solution {
    public long flowerGame(int n, int m) {
        int n_odd = n / 2, n_even = n - n_odd, m_odd = m / 2, m_even = m - m_odd;
        return (long) n_odd * m_even + (long) n_even * m_odd;
    }
}
