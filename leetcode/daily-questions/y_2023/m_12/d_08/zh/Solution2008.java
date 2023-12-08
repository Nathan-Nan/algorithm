package y_2023.m_12.d_08.zh;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-earnings-from-taxi/description/?envType=daily-question&envId=2023-12-08">...</a>
 */
public class Solution2008 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        List<int[]>[] groups = new ArrayList[n + 1];
        for (int[] r : rides) {
            int start = r[0], end = r[1], tip = r[2];
            if (groups[end] == null) {
                groups[end] = new ArrayList<>();
            }
            groups[end].add(new int[]{start, end - start + tip});
        }

        long[] f = new long[n + 1];
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1];
            if (groups[i] != null) {
                for (int[] p : groups[i]) {
                    f[i] = Math.max(f[i], f[p[0]] + p[1]);
                }
            }
        }
        return f[n];
    }
}
