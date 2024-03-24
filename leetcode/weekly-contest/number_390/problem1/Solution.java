package number_390.problem1;


/**
 * <a href="https://leetcode.cn/contest/weekly-contest-390/problems/maximum-length-substring-with-two-occurrences/">...</a>
 */
public class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (check(s.substring(i, j))) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    private boolean check(String str) {
        int[] cnt = new int[26];
        for (char c : str.toCharArray()) {
            cnt[c - 'a']++;
            if (cnt[c - 'a'] > 2) {
                return false;
            }
        }
        return true;
    }
}
