package number_389.problem2;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-389/problems/count-substrings-starting-and-ending-with-given-character/">...</a>
 */
public class Solution {

    public long countSubstrings(String s, char c) {
        long count = 0, aCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count += 1 + aCnt;
                aCnt++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("abada", 'a'));
        System.out.println(solution.countSubstrings("zzz", 'z'));
    }
}
