package number_391.p2;

/**
 * <a href="https://leetcode.cn/problems/water-bottles-ii/description/">...</a>
 */
public class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0;
        int emptyBottles = 0;
        while (numBottles + emptyBottles >= numExchange) {
            ans += numBottles;
            emptyBottles += numBottles - numExchange;
            numBottles = 1;
            numExchange++;
        }
        return ans + numBottles;
    }
}
