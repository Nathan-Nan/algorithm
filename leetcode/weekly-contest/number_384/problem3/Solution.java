package number_384.problem3;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-384/problems/maximum-palindromes-after-operations/">...</a>
 */
public class Solution {

    public int maxPalindromesAfterOperations(String[] words) {
        int ans = 0;
        char[] chars = new char[26];
        for (String word : words) {
            if (isPalindromes(word)) {
                ans++;
            }
            for (char c : word.toCharArray()) {
                chars[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0 && chars[i] % 2 == 0) {
                ans++;
            }
        }


        return ans;
    }

    private boolean isPalindromes(String word) {
        int l = 0, r = word.length() - 1;
        while (l <= r) {
            if (word.charAt(l) != word.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxPalindromesAfterOperations(new String[]{"abbb", "ba", "aa"}));
        System.out.println(solution.maxPalindromesAfterOperations(new String[]{"abc", "ab"}));
        System.out.println(solution.maxPalindromesAfterOperations(new String[]{"cd", "ef", "a"}));
        System.out.println(solution.maxPalindromesAfterOperations(new String[]{"aaa", "ab"}));
    }
}
