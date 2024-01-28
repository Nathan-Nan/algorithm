package y_2024.m_01.d_28.problem_365;

/**
 * <a href="https://leetcode.cn/problems/water-and-jug-problem/description/?envType=daily-question&envId=2024-01-28">...</a>
 * <p>
 * 数学法
 */
public class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        if (jug1Capacity == 0 || jug2Capacity == 0) {
            return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        }

        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int t = y;
            y = x % y;
            x = t;
        }
        return x;
    }
}
