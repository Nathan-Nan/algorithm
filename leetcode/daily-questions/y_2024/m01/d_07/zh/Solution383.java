package y_2024.m01.d_07.zh;

/**
 * <a href="https://leetcode.cn/problems/ransom-note/description/?envType=daily-question&envId=2024-01-07">...</a>
 */
public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rChars = getChars(ransomNote);
        int[] mChars = getChars(magazine);
        for (int i = 0; i < 26; i++) {
            if (rChars[i] > mChars[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getChars(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        return chars;
    }

}
