package y_2024.m_02.d_02.problem_1686;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/stone-game-vi/description/?envType=daily-question&envId=2024-02-02">...</a>
 */
public class Solution {

    public int stoneGameVI(int[] a, int[] b) {
        int n = a.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> a[j] + b[j] - a[i] - b[i]);
        int diff = 0;
        for (int i = 0; i < n; i++) {
            diff += i % 2 == 0 ? a[ids[i]] : -b[ids[i]];
        }
        return Integer.compare(diff, 0);
    }
}
