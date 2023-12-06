package y_2023.m_12.d_06.en;

/**
 * <a href="https://leetcode.cn/problems/calculate-money-in-leetcode-bank/description/">...</a>
 */
public class Solution1716 {
    /**
     * 递归解法
     */
    public int totalMoney(int n) {
        if (n == 1) return 1;
        if (n < 8) return n + totalMoney(n - 1);
        return totalMoney(7) + totalMoney(n - 7) + (n - 7);
    }

    /**
     * 模拟解法
     */
    public int totalMoney1(int n) {
        int a = n / 7, b = n % 7, ans = 0, k = 1;
        while (a-- > 0) {
            ans += (k + (k + 6)) * 7 / 2;
            k++;
        }
        while (b-- > 0) {
            ans += k++;
        }
        return ans;
    }

    /**
     * 模拟解法优化
     */
    public int totalMoney2(int n) {
        int a = n / 7, b = n % 7;
        int a1 = (1 + 7) * 7 / 2, a2 = (a + (a + 6)) * 7 / 2;
        int ans1 = (a1 + a2) * a / 2;
        int ans2 = ((a + 1) + (a + b)) * b / 2;
        return ans1 + ans2;
    }
}
