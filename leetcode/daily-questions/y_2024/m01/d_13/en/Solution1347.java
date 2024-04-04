package y_2024.m01.d_13.en;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/?envType=daily-question&envId=2024-01-13">...</a>
 */
public class Solution1347 {
    public int minSteps(String s, String t) {
        int[] sChars = getChars(s);
        int[] tChars = getChars(t);
        int ans = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] < tChars[i]) {
                ans += tChars[i] - sChars[i];
            }
        }
        return ans;
    }

    private int[] getChars(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        return chars;
    }

    public static void main(String[] args) {
        Solution1347 solution = new Solution1347();
        System.out.println(solution.minSteps("bab", "aba"));
        System.out.println(solution.minSteps("leetcode", "practice"));
        System.out.println(solution.minSteps("anagram", "mangaar"));
        System.out.println(solution.minSteps("xxyyzz", "xxyyzz"));
        System.out.println(solution.minSteps("friend", "family"));
    }
}
