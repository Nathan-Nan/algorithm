package double_weekly.number124.problem_2;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-124/problems/apply-operations-to-make-string-empty/">...</a>
 */
public class Solution {
    public String lastNonEmptyString(String s) {
        int[] cnt = new int[26];
        int max = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            max = Math.max(max, ++cnt[c - 'a']);
        }
        StringBuilder ans = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (max == cnt[chars[i] - 'a'] && !set.contains(chars[i])) {
                ans.append(chars[i]);
                set.add(chars[i]);
            }
        }

        return ans.reverse().toString();
    }
}
