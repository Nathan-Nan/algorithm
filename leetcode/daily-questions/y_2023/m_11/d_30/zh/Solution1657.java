package y_2023.m_11.d_30.zh;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/determine-if-two-strings-are-close/?envType=daily-question&envId=2023-11-30">...</a>
 */
public class Solution1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] word1Chars = new int[26];
        for (char c : word1.toCharArray()) {
            word1Chars[c - 'a']++;
        }
        int[] word2Chars = new int[26];
        for (char c : word2.toCharArray()) {
            word2Chars[c - 'a']++;
        }
        // 判断字符集是否相等
        for (int i = 0; i < 26; i++) {
            if ((word1Chars[i] == 0) != (word2Chars[i] == 0)) return false;
        }
        Arrays.sort(word1Chars);
        Arrays.sort(word2Chars);
        return Arrays.equals(word1Chars, word2Chars);
    }
}
