package y_2024.m01.d_17.zh;

/**
 * <a href="https://leetcode.cn/problems/find-maximum-number-of-string-pairs/description/?envType=daily-question&envId=2024-01-17">...</a>
 */
public class Solution2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
