package number_383.Problem_2;

/**
 * <a href="https://leetcode.cn/problems/minimum-time-to-revert-word-to-initial-state-i/description/">...</a>
 */
public class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int len = word.length();
        int res = 0;  // 切割次数
        int sum = (int) Math.ceil((double) len / k); // 最大切割次数
        for (int i = k; i < len; i += k) {
            res++;
            if (word.indexOf(word.substring(i)) == 0) return res;
        }
        return sum;
    }
}
