package y_2023.m_11.d_26.zh;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/description/?envType=daily-question&envId=2023-11-26">...</a>
 */
public class Solution828 {
    /**
     * 暴力解法，超时
     */
    public int uniqueLetterString(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                ans += countUniqueChars(s.substring(i, j));
            }
        }
        return ans;
    }

    private int countUniqueChars(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'A']++;
        }
        int ans = 0;
        for (int cnt : count) {
            ans += cnt == 1 ? 1 : 0;
        }
        return ans;
    }

    /**
     * 使用数组记录当前字符上次出现的位置
     */
    public int uniqueLetterString1(String s) {
        int ans = 0, total = 0;
        int[] last0 = new int[26], last1 = new int[26];
        Arrays.fill(last0, -1);
        Arrays.fill(last1, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            total += i - 2 * last0[c] + last1[c];
            ans += total;
            last1[c] = last0[c];
            last0[c] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution828 solution = new Solution828();
        System.out.println(solution.uniqueLetterString("ABC"));
        System.out.println(solution.uniqueLetterString("ABA"));
        System.out.println(solution.uniqueLetterString("LEETCODE"));
    }
}
