package y_2023.m_12.d_25.en;

/**
 * <a href="https://leetcode.com/problems/decode-ways/?envType=daily-question&envId=2023-12-25">...</a>
 */
public class Solution91 {
    /**
     * DP 解法
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int n = s.length();
        s = " " + s;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int a = s.charAt(i) - '0', b = (s.charAt(i - 1) - '0') * 10 + a;
            if (1 <= a && a <= 9) {
                dp[i] = dp[i - 1];
            }
            if (10 <= b && b <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution91 solution = new Solution91();
        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("2101"));
    }
}
