package y_2023.m_12.d_16.en;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/?envType=daily-question&envId=2023-12-16">...</a>
 */
public class Solution242 {

    public boolean isAnagram(String s, String t) {
        return Arrays.equals(getChars(s), getChars(t));
    }

    private int[] getChars(String s) {
        int[] a = new int[26];
        for (byte b : s.getBytes(Charset.defaultCharset())) {
            a[b - 'a']++;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution242 solution = new Solution242();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
    }
}
