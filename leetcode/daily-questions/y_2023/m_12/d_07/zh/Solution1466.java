package y_2023.m_12.d_07.zh;

import java.util.*;


/**
 * <a href="https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=daily-question&envId=2023-12-07">...</a>
 */
public class Solution1466 {
    /**
     * DFS 解法
     */
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] connection : connections) {
            graph.computeIfAbsent(connection[0], c -> new ArrayList<>()).add(new int[]{connection[1], 1});
            graph.computeIfAbsent(connection[1], c -> new ArrayList<>()).add(new int[]{connection[0], 0});
        }
        return dfs(graph, new boolean[n], 0);
    }

    private int dfs(Map<Integer, List<int[]>> graph, boolean[] visited, int cur) {
        visited[cur] = true;
        int countOfChanges = 0;
        if (graph.containsKey(cur)) {
            for (int[] neighbors : graph.get(cur)) {
                if (visited[neighbors[0]]) {
                    continue;
                }
                countOfChanges += neighbors[1];
                countOfChanges += dfs(graph, visited, neighbors[0]);
            }
        }
        return countOfChanges;
    }

    /**
     * BFS 解法
     */
    public int minReorder1(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] connection : connections) {
            graph.computeIfAbsent(connection[0], c -> new ArrayList<>()).add(new int[]{connection[1], 1});
            graph.computeIfAbsent(connection[1], c -> new ArrayList<>()).add(new int[]{connection[0], 0});
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int ans = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (int[] neighbor : graph.get(cur)) {
                if (visited[neighbor[0]]) {
                    continue;
                }
                queue.offer(neighbor[0]);
                visited[neighbor[0]] = true;
                ans += neighbor[1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1466 solution = new Solution1466();
        System.out.println(solution.minReorder1(3, new int[][]{{1, 2}, {2, 0}}));
    }

}
