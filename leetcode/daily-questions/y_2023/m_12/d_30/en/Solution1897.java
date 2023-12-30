package y_2023.m_12.d_30.en;

/**
 * <a href="https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/description/?envType=daily-question&envId=2023-12-30">...</a>
 */
public class Solution1897 {
    public boolean makeEqual(String[] words) {
        int[] chars = new int[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                chars[word.charAt(i) - 'a']++;
            }
        }
        for (int cnt : chars) {
            if (cnt % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
