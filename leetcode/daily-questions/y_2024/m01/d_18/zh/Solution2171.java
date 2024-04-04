package y_2024.m01.d_18.zh;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/description/?envType=daily-question&envId=2024-01-18">...</a>
 */
public class Solution2171 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0, max = 0;
        int n = beans.length;
        for (int i = 0; i < n; i++) {
            sum += beans[i];
            max = Math.max(max, (long) (n - i) * beans[i]);
        }
        return sum - max;
    }
}
