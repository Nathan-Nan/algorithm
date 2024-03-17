package number_389.problem3;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-389/problems/minimum-deletions-to-make-string-k-special/">...</a>
 */
public class Solution {

    public int minimumDeletions(String word, int k) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); ++i) {
            count[word.charAt(i) - 'a'] += 1;
        }
        Arrays.sort(count);
        int res = word.length();
        int prefixSum = 0;
        for (int i = 0; i < 26; ++i) {
            int result = prefixSum;
            for (int j = i + 1; j < 26; ++j) {
                if (count[j] > count[i] + k) {
                    result += count[j] - count[i] - k;
                }
            }
            res = Math.min(res, result);
            prefixSum += count[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDeletions("aabcaba", 0));
    }
}
