package y_2024.m03.d_02.problem2368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/reachable-nodes-with-restrictions/description/?envType=daily-question&envId=2024-03-02">...</a>
 */
public class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] isRestricted = new boolean[n];
        for (int x : restricted) {
            isRestricted[x] = true;
        }
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            if (!isRestricted[x] && !isRestricted[y]) {
                g[x].add(y); // 都不受限才连边
                g[y].add(x);
            }
        }
        return dfs(0, -1, g);
    }

    private int dfs(int x, int fa, List<Integer>[] g) {
        int cnt = 1;
        for (int y : g[x]) {
            if (y != fa) {
                cnt += dfs(y, x, g);
            }
        }
        return cnt;
    }
}
