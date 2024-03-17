package number_389.problem1;

import java.util.Objects;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-389/problems/existence-of-a-substring-in-a-string-and-its-reverse/">...</a>
 */
public class Solution {
    public boolean isSubstringPresent(String s) {
        if (s.length() == 1) return false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) return true;
            if (i < s.length() - 1 && s.charAt(i - 1) == s.charAt(i + 1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubstringPresent("leetcode"));
        System.out.println(solution.isSubstringPresent("abcba"));
        System.out.println(solution.isSubstringPresent("abcd"));
        System.out.println(solution.isSubstringPresent("ausoee"));
    }
}
