package y_2024.m04.d04.problem2192;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/?envType=daily-question&envId=2024-04-04">...</a>
 */
public class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[1]].add(e[0]); // 反向建图
        }

        List<Integer>[] ans = new ArrayList[n];
        Arrays.setAll(ans, i -> new ArrayList<>());
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false);
            dfs(i, g, vis); // 从 i 开始 DFS
            vis[i] = false; // ans[i] 不含 i
            for (int j = 0; j < n; j++) {
                if (vis[j]) {
                    ans[i].add(j);
                }
            }
        }
        return Arrays.asList(ans);
    }

    private void dfs(int x, List<Integer>[] g, boolean[] vis) {
        vis[x] = true; // 避免重复访问
        for (int y : g[x]) {
            if (!vis[y]) {
                dfs(y, g, vis); // 只递归没有访问过的点
            }
        }
    }
}
