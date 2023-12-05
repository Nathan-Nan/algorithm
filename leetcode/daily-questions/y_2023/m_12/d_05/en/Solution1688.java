package y_2023.m_12.d_05.en;

/**
 * <a href="https://leetcode.cn/problems/count-of-matches-in-tournament/description/">...</a>
 */
public class Solution1688 {
    /**
     * 模拟比赛配对
     */
    public int numberOfMatches(int n) {
        if (n == 0 || n == 1) return n;
        int ans = 0;
        while (n > 1) {
            ans += n / 2;
            int mod = n % 2;
            n = (n - mod) / 2 + mod;
        }
        return ans;
    }

    /**
     * 一共有 n 个队伍，只有 1 个队伍会夺冠那么就会有 n - 1 个队伍被淘汰，即会有 n - 1 场比赛
     */
    public int numberOfMatches1(int n) {
        return n - 1;
    }

    public static void main(String[] args) {
        Solution1688 solution = new Solution1688();
        System.out.println(solution.numberOfMatches(7));
        System.out.println(solution.numberOfMatches(14));
    }
}
