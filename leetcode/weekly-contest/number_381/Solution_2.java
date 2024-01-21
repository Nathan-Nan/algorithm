package number_381;

import java.util.*;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-381/problems/count-the-number-of-houses-at-a-certain-distance-i/">...</a>
 */
public class Solution_2 {
    /**
     * 解法一：模拟，超时
     */
    public int[] countOfPairs(int n, int x, int y) {
        Map<Integer, Set<Integer>> graph = new HashMap<>(n);
        for (int i = 1; i < n; i++) {
            graph.computeIfAbsent(i, v -> new HashSet<>()).add(i + 1);
            graph.computeIfAbsent(i + 1, v -> new HashSet<>()).add(i);
        }
        graph.computeIfAbsent(x, v -> new HashSet<>()).add(y);
        graph.computeIfAbsent(y, v -> new HashSet<>()).add(x);
        int[] ans = new int[n];
        Set<Integer> path = new LinkedHashSet<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                path.clear();
                path.add(i);
                int steps = getSteps(graph, i, j, path);
                ans[steps - 1] += 2;
            }
        }

        return ans;
    }

    private int getSteps(Map<Integer, Set<Integer>> graph, int x, int y, Set<Integer> p) {
        if (x == y) return 0;
        Set<Integer> path = graph.getOrDefault(x, new HashSet<>());
        if (path.contains(y)) return 1;
        int steps = 1000;

        for (Integer i : path) {
            if (p.contains(i)) continue;
            p.add(i);
            int s = getSteps(graph, i, y, p);
            p.remove(i);
            steps = Math.min(steps, s);
        }

        return steps + 1;
    }


    /**
     * 解法二：求两点之间的最短路径
     */
    public int[] countOfPairs1(int n, int x, int y) {
        x--;
        y--;
        int[] ans = new int[n];
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                distance[i][j] = Math.min(Math.abs(i - x) + Math.abs(y - j), Math.abs(j - x) + Math.abs(y - i)) + 1;
                distance[i][j] = Math.min(distance[i][j], i - j);
                ans[distance[i][j] - 1] += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        System.out.println(Arrays.toString(solution.countOfPairs(3, 1, 3)));
        System.out.println(Arrays.toString(solution.countOfPairs(5, 2, 4)));
        System.out.println(Arrays.toString(solution.countOfPairs(4, 1, 1)));
        System.out.println(Arrays.toString(solution.countOfPairs(100, 41, 67)));
    }
}
