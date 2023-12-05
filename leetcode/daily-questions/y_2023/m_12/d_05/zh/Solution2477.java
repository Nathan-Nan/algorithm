package y_2023.m_12.d_05.zh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-fuel-cost-to-report-to-the-capital/description/?envType=daily-question&envId=2023-12-05">...</a>
 */
public class Solution2477 {
    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads == null || roads.length == 0) {
            return 0;
        }
        int n = roads.length;
        List<Integer>[] g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<Integer>());
        for (int[] road : roads) {
            g[road[0]].add(road[1]);
            g[road[1]].add(road[0]);
        }
        dfs(0, -1, g, seats);
        return ans;
    }

    private long ans = 0L;

    private int dfs(int s, int father, List<Integer>[] g, int seats) {
        int size = 1;
        for (Integer child : g[s]) {
            if (child != father) {
                size += dfs(child, s, g, seats);
            }
        }
        if (s > 0) {
            ans += (size - 1) / seats + 1;
        }
        return size;
    }
}
