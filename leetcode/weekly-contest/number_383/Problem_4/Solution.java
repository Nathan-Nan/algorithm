package number_383.Problem_4;

/**
 * <a href="https://leetcode.cn/problems/minimum-time-to-revert-word-to-initial-state-ii/description/">...</a>
 */
public class Solution {
    /**
     * <a href="https://leetcode.cn/problems/minimum-time-to-revert-word-to-initial-state-ii/solutions/2630932/z-han-shu-kuo-zhan-kmp-by-endlesscheng-w44j/">...</a>
     */
    public int minimumTimeToInitialState(String S, int k) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(z[i - l], r - i + 1);
            }
            while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
                l = i;
                r = i + z[i];
                z[i]++;
            }
            if (i % k == 0 && z[i] >= n - i) {
                return i / k;
            }
        }
        return (n - 1) / k + 1;
    }
}
