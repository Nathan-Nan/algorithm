package number_385.problem3;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/most-frequent-prime/description/">...</a>
 */
public class Solution {

    private int[][] mat;
    private int m;
    private int n;
    private Map<Integer, Integer> cache;

    private final int[][] offsets = new int[][]{
            {0, 1},
            {1, 1},
            {1, 0},
            {1, -1},
            {0, -1},
            {-1, -1},
            {-1, 0},
            {-1, 1},
    };

    public int mostFrequentPrime(int[][] mat) {
        this.mat = mat;
        this.m = mat.length;
        this.n = mat[0].length;
        this.cache = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] offset : offsets) {
                    dfs(i, j, mat[i][j], offset);
                }
            }
        }
        int ans = -1;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            if (entry.getValue() > max || (entry.getValue() == max && entry.getKey() > ans)) {
                ans = entry.getKey();
                max = entry.getValue();
            }
        }
        return ans;
    }

    private void dfs(int i, int j, int pre, int[] offset) {
        i = i + offset[0];
        j = j + offset[1];
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        pre = pre * 10 + mat[i][j];
        if (pre > 10 && isPrime(pre)) {
            cache.merge(pre, 1, Integer::sum);
        }
        dfs(i, j, pre, offset);
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
