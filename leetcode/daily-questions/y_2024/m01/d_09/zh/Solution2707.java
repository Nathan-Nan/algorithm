package y_2024.m01.d_09.zh;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/extra-characters-in-a-string/description/?envType=daily-question&envId=2024-01-09">...</a>
 */
public class Solution2707 {
    /**
     * DP
     * 参考题解：<a href="https://leetcode.cn/problems/extra-characters-in-a-string/solutions/2286613/dong-tai-gui-hua-cong-ji-yi-hua-sou-suo-wtd7a/?envType=daily-question&envId=2024-01-09" /a>
     */
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = Arrays.stream(dictionary).collect(Collectors.toSet());
        int n = s.length();
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = f[i] + 1;
            for (int j = 0; j <= i; j++) {
                if (set.contains(s.substring(j, i + 1))) {
                    f[i + 1] = Math.min(f[i + 1], f[j]);
                }
            }
        }
        return f[n];
    }
}
