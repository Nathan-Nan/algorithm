package y_2023.m_11.d_27.en;

/**
 * <a href="https://leetcode.com/problems/knight-dialer/?envType=daily-question&envId=2023-11-27">...</a>
 */
public class Solution935 {
    static final int mod = (int) 1e9 + 7;
    static final int[][] MOVES = {
            /*0*/ {4, 6},
            /*1*/ {6, 8},
            /*2*/ {7, 9},
            /*3*/ {4, 8},
            /*4*/ {0, 3, 9},
            /*5*/ {},
            /*6*/ {0, 1, 7},
            /*7*/ {2, 6},
            /*8*/ {1, 3},
            /*9*/ {2, 4}
    };
    static final int[][] cache = new int[5001][10];

    /**
     * DP
     * <p>
     * dp[n][i] 表示从 i 开始的不同电话号码个数
     */
    public int knightDialer(int n) {
        return knightDialer(n, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    int knightDialer(int remaining, int[] nextNumbers) {
        if (remaining == 1) return nextNumbers.length;
        int count = 0;

        for (int nextNumber : nextNumbers) {
            int cur = cache[remaining][nextNumber];
            if (cur == 0) {
                cur = knightDialer(remaining - 1, MOVES[nextNumber]);
                cache[remaining][nextNumber] = cur;
            }
            count += cur;
            count %= mod;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution935 solution = new Solution935();
        System.out.println(solution.knightDialer(1) == 10);
        System.out.println(solution.knightDialer(2) == 20);
        System.out.println(solution.knightDialer(3131) == 136006598);
    }

}
