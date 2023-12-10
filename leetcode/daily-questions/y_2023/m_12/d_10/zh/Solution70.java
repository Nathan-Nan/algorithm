package y_2023.m_12.d_10.zh;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/?envType=daily-question&envId=2023-12-10">...</a>
 */
public class Solution70 {
    /**
     * 递归解法，超时
     */
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 递归解法 + 备忘录，AC
     */
    private Map<Integer, Integer> member = new HashMap<>();

    public int climbStairs1(int n) {
        if (member.containsKey(n)) return member.get(n);
        if (n == 1 || n == 2) {
            member.put(n, n);
            return n;
        }
        Integer ans1 = member.get(n - 1);
        if (ans1 == null) {
            ans1 = climbStairs1(n - 1);
            member.put(n - 1, ans1);
        }
        Integer ans2 = member.get(n - 2);
        if (ans2 == null) {
            ans2 = climbStairs1(n - 2);
            member.put(n - 2, ans2);
        }
        member.put(n, ans1 + ans2);
        return member.get(n);
    }

    /**
     * 递推优化，AC
     */
    public int climbStairs2(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2, sum;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
