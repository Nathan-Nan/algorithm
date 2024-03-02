package double_weekly.number125.problem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-125/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network/">...</a>
 */
public class Solution {

    private int n;
    private List<int[]>[] g;
    private int[] count;
    private int signalSpeed;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        this.n = edges.length + 1;
        this.count = new int[n];
        this.g = new ArrayList[n];
        this.signalSpeed = signalSpeed;
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int[] edge : edges) {
            g[edge[0]].add(new int[]{edge[1], edge[2]});
            g[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        for (int i = 0; i < n; i++) {
            // 当前节点左边有多少个被 signalSpeed 整除的节点
            int left = 0;
            for (int[] neighbor : g[i]) {
                // 当前节点左边有多少个被 signalSpeed 整除的节点
                int right = dfs(neighbor[0], i, neighbor[1]);
                count[i] += left * right;
                left += right;
            }
        }
        return count;
    }

    private int dfs(int cur, int fa, int weight) {
        int res = 0;
        if (weight % signalSpeed == 0) res++;
        for (int[] neighbors : g[cur]) {
            if (fa == neighbors[0]) {
                continue;
            }
            res += dfs(neighbors[0], cur, weight + neighbors[1]);
        }
        return res;
    }
}
