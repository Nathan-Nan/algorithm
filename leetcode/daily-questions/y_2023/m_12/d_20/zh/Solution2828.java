package y_2023.m_12.d_20.zh;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/check-if-a-string-is-an-acronym-of-words/description/?envType=daily-question&envId=2023-12-20">...</a>
 */
public class Solution2828 {
    public boolean isAcronym(List<String> words, String s) {
        if (s.length() != words.size()) return false;
        for (int i = 0; i < words.size(); i++) {
            if (s.charAt(i) != words.get(i).charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2828 solution = new Solution2828();
        System.out.println(solution.isAcronym(Arrays.asList("alice", "bob", "charlie"), "abc"));
        System.out.println(solution.isAcronym(Arrays.asList("an", "apple"), "a"));
        System.out.println(solution.isAcronym(Arrays.asList("never", "gonna", "give", "up", "on", "you"), "ngguoy"));
    }
}
