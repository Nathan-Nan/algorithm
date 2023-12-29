package y_2023.m_12.d_29.zh;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/buy-two-chocolates/description/?envType=daily-question&envId=2023-12-29">...</a>
 * {@link y_2023.m_12.d_20.en.Solution2706}
 */
public class Solution2706 {

    /**
     * 排序解法
     */
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int ans = money - prices[0] - prices[1];
        return ans >= 0 ? ans : money;
    }
}
