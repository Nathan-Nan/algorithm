package y_2023.m_12.d_20.en;

/**
 * <a href="https://leetcode.com/problems/buy-two-chocolates/description/?envType=daily-question&envId=2023-12-20">...</a>
 */
public class Solution2706 {
    public int buyChoco(int[] prices, int money) {
        int price1 = Integer.MAX_VALUE, price2 = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < price1) {
                price2 = price1;
                price1 = price;
            } else if (price < price2) {
                price2 = price;
            }
        }
        return price1 + price2 > money ? money : money - price1 - price2;
    }
}
