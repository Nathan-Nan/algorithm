package y_2024.m01.d_20.zh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/split-strings-by-separator/description/?envType=daily-question&envId=2024-01-20">...</a>
 */
public class Solution2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            int len = word.length(), i = 0;
            while (i < len) {
                while (i < len && word.charAt(i) == separator) i++;
                int j = i + 1;
                while (j < len && word.charAt(j) != separator) j++;
                if (i < len && j <= len) {
                    result.add(word.substring(i, j));
                }
                i = j + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2788 solution = new Solution2788();
        System.out.println(solution.splitWordsBySeparator(Arrays.asList("one.two.three", "four.five", "six"), '.'));
        System.out.println(solution.splitWordsBySeparator(Arrays.asList("$easy$", "$problem$"), '$'));
        System.out.println(solution.splitWordsBySeparator(Arrays.asList("|||"), '|'));
    }
}
