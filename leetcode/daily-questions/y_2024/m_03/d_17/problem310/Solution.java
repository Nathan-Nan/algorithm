package y_2024.m_03.d_17.problem310;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-height-trees/description/?envType=daily-question&envId=2024-03-17">...</a>
 */
public class Solution {
    private List<Integer>[] g;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        g = new ArrayList[n];
        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            g[a].add(b);
            g[b].add(a);
        }
        int[] subHeight = new int[n], height = new int[n];
        dfs(0, -1, subHeight);
        // 手动设置height[0]
        height[0] = subHeight[0];
        reroot(0, -1, subHeight, height);
        List<Integer> ret = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < min) {
                ret.clear();
                min = height[i];
                ret.add(i);
            } else if (height[i] == min) {
                ret.add(i);
            }
        }
        return ret;
    }

    private void dfs(int cur, int fa, int[] subHeight) {
        for (int i = 0; i < g[cur].size(); i++) {
            int next = g[cur].get(i);
            if (next != fa) {
                dfs(next, cur, subHeight);
                subHeight[cur] = Math.max(subHeight[cur], subHeight[next] + 1);
            }
        }
    }

    private void reroot(int cur, int fa, int[] subHeight, int[] height) {
        int first = -1, second = -1;
        for (int i = 0; i < g[cur].size(); i++) {
            int next = g[cur].get(i);
            if (subHeight[next] > first) {
                second = first;
                first = subHeight[next];
            } else if (subHeight[next] > second) {
                second = subHeight[next];
            }
        }
        for (int i = 0; i < g[cur].size(); i++) {
            int next = g[cur].get(i);
            if (next != fa) {
                subHeight[cur] = (subHeight[next] == first ? second : first) + 1;
                height[next] = Math.max(subHeight[cur] + 1, subHeight[next]);
                // 此时不更新subHeight[next]也可以, 因为此时subHeight[next]的值已经用不到了, 下一次遍历到next的邻接点时,
                // 会用这里next临界点的subHeight值更新subHeight的值
                reroot(next, cur, subHeight, height);
            }
        }
    }
}
