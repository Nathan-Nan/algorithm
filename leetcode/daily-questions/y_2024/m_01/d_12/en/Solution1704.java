package y_2024.m_01.d_12.en;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/determine-if-string-halves-are-alike/description/?envType=daily-question&envId=2024-01-12">...</a>
 */
public class Solution1704 {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = Stream.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').collect(Collectors.toSet());
        int l = 0, r = s.length() - 1, vowel = 0;
        while (l < r) {
            if (vowels.contains(s.charAt(l++))) {
                vowel++;
            }
            if (vowels.contains(s.charAt(r--))) {
                vowel--;
            }
        }
        return vowel == 0;
    }
}
