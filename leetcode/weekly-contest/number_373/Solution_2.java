package number_373;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-373/problems/count-beautiful-substrings-i/">...</a>
 */
public class Solution_2 {

    /**
     * 第二题通过，第四题超时
     */
    public int beautifulSubstrings(String s, int k) {
        Set<Character> set = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        int[][] arrs = new int[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                arrs[i][0] = i == 0 ? 1 : arrs[i - 1][0] + 1;
                arrs[i][1] = i == 0 ? 0 : arrs[i - 1][1];
            } else {
                arrs[i][0] = i == 0 ? 0 : arrs[i - 1][0];
                arrs[i][1] = i == 0 ? 1 : arrs[i - 1][1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isBeautifulSubstrings(arrs, i, j, k)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isBeautifulSubstrings(int[][] arrs, int i, int j, int k) {
        if (i == j) return false;
        int vowels = arrs[j][0] - (i == 0 ? 0 : arrs[i - 1][0]);
        int consonants = arrs[j][1] - (i == 0 ? 0 : arrs[i - 1][1]);
        return vowels == consonants && (vowels * consonants) % k == 0;
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        System.out.println(solution.beautifulSubstrings("baeyh", 2));
        System.out.println(solution.beautifulSubstrings("abba", 1));
        System.out.println(solution.beautifulSubstrings("bcdf", 1));
    }
}
