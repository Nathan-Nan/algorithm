package y_2024.m_01.d_13.zh;

/**
 * <a href="https://leetcode.cn/problems/construct-string-with-repeat-limit/description/?envType=daily-question&envId=2024-01-13">...</a>
 */
public class Solution2182 {
    /**
     * 贪心思想
     */
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] sChars = new int[26];
        for (byte b : s.getBytes()) {
            sChars[b - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            int k = i - 1;
            while (true) {
                for (int j = 0; j < repeatLimit && sChars[i] > 0; j++) {
                    sChars[i]--;
                    builder.append((char) (i + 'a'));
                }
                if (sChars[i] == 0) {
                    break;
                }
                while (k >= 0 && sChars[k] == 0) {
                    k--;
                }
                if (k < 0) {
                    break;
                }
                sChars[k]--;
                builder.append((char) (k + 'a'));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution2182 solution = new Solution2182();
        System.out.println(solution.repeatLimitedString("cczazcc", 3));
        System.out.println(solution.repeatLimitedString("aababab", 2));
    }
}
