package number_390.problem1;

public class Solution1 {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        int[] chars = new int[26];
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            while (chars[s.charAt(i) - 'a'] > 2) {
                chars[s.charAt(l) - 'a']--;
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
