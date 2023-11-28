package y_2023.m_11.d_28.en;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/?envType=daily-question&envId=2023-11-28">...</a>
 */
public class Solution2147 {
    public int numberOfWays(String corridor) {
        int ans = 1, cntS = 0, pre = 0;
        for (int i = 0; i < corridor.length(); ++i) {
            if (corridor.charAt(i) == 'S') {
                // 对第 3,5,7,... 个座位，可以在其到其左侧最近座位之间的任意一个位置放置屏风
                ++cntS;
                if (cntS >= 3 && cntS % 2 == 1) {
                    ans = ans * (i - pre) % 1000000007;
                }
                pre = i; // 记录上一个座位的位置
            }
        }
        return cntS > 0 && cntS % 2 == 0 ? ans : 0; // 座位个数必须为正偶数
    }

    public static void main(String[] args) {
        Solution2147 solution = new Solution2147();
        System.out.println(solution.numberOfWays("SSPPSPS"));
        System.out.println(solution.numberOfWays("PPSPSP"));
        System.out.println(solution.numberOfWays("S"));
    }
}
