package y_2023.m_12.d_02.en;

import java.nio.charset.StandardCharsets;

/**
 * <a href="https://leetcode.cn/problems/find-words-that-can-be-formed-by-characters/description/">...</a>
 */
public class Solution1160 {

    public int countCharacters(String[] words, String chars) {
        int[] chars_arr = convertToCharArray(chars);
        int ans = 0;
        for (String word : words) {
            if (isFormedWord(word, chars_arr)) {
                ans += word.length();
            }
        }
        return ans;
    }

    private boolean isFormedWord(String word, int[] chars) {
        int[] wordChars = convertToCharArray(word);
        for (int i = 0; i < wordChars.length; i++) {
            if (wordChars[i] > chars[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] convertToCharArray(String word) {
        int[] chars = new int[26];
        for (byte b : word.getBytes(StandardCharsets.UTF_8)) {
            chars[b - 'a']++;
        }
        return chars;
    }

    public static void main(String[] args) {
        Solution1160 solution = new Solution1160();
        System.out.println(solution.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(solution.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }
}
