package y_2023.m_12.d_22.en;

/**
 * <a href="https://leetcode.com/problems/maximum-score-after-splitting-a-string/?envType=daily-question&envId=2023-12-22">...</a>
 */
public class Solution1422 {

    public int maxScore(String s) {
        int[] zeros = new int[s.length()], ones = new int[s.length()];
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            zeros[0] = 1;
        }
        if (chars[chars.length - 1] == '1') {
            ones[chars.length - 1] = 1;
        }
        for (int i = 1; i < chars.length; i++) {
            zeros[i] = chars[i] == '0' ? zeros[i - 1] + 1 : zeros[i - 1];
        }
        for (int i = chars.length - 2; i >= 0; i--) {
            ones[i] = chars[i] == '1' ? ones[i + 1] + 1 : ones[i + 1];
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length - 1; i++) {
            ans = Math.max(ans, zeros[i] + ones[i + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1422 solution = new Solution1422();
        System.out.println(solution.maxScore("011101"));
        System.out.println(solution.maxScore("00111"));
        System.out.println(solution.maxScore("1111"));
    }
}
