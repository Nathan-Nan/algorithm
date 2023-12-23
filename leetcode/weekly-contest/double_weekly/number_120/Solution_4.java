package double_weekly.number_120;

import java.util.*;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-120/problems/find-number-of-coins-to-place-in-tree-nodes/">...</a>
 */
public class Solution_4 {
    public long[] placedCoins(int[][] edges, int[] cost) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        long[] coins = new long[cost.length];
        Arrays.fill(coins, -1);
        dfs(graph, coins, cost, 0, -1);
        return coins;
    }

    private Queue[] dfs(Map<Integer, List<Integer>> graph, long[] coins, int[] cost, int current, int father) {
        Queue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        minQueue.offer(cost[current]);
        maxQueue.offer(cost[current]);
        for (Integer node : graph.getOrDefault(current, new ArrayList<>())) {
            if (node == father) continue;
            Queue[] queues = dfs(graph, coins, cost, node, current);
            if (minQueue.size() < queues[0].size()) {
                Queue<Integer> tmp = minQueue;
                minQueue = queues[0];
                queues[0] = tmp;
                tmp = maxQueue;
                maxQueue = queues[1];
                queues[1] = tmp;
            }

            minQueue.addAll(queues[0]);
            maxQueue.addAll(queues[1]);
        }
        if (minQueue.size() < 3) {
            coins[current] = 1;
        } else {
            int a = maxQueue.poll(), b = maxQueue.poll(), c = maxQueue.poll(), d = minQueue.poll(), e = minQueue.poll();
            long coin = Math.max((long) a * b * c, (long) a * d * e);
            maxQueue.offer(a);
            maxQueue.offer(b);
            maxQueue.offer(c);
            minQueue.offer(d);
            minQueue.offer(e);
            coins[current] = coin < 0 ? 0 : coin;
        }

        return new Queue[]{minQueue, maxQueue};
    }

    public static void main(String[] args) {
        Solution_4 solution = new Solution_4();
        // System.out.println(Arrays.toString(solution.placedCoins(new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}}, new int[]{1, 2, 3, 4, 5, 6})));
        // System.out.println(Arrays.toString(solution.placedCoins(new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 6}, {2, 7}, {2, 8}}, new int[]{1, 4, 2, 3, 5, 7, 8, -4, 2})));
        // System.out.println(Arrays.toString(solution.placedCoins(new int[][]{{0, 1}, {0, 2}}, new int[]{1, 2, -2})));
        // System.out.println(Arrays.toString(solution.placedCoins(solution.genParams1(), solution.genParams2())));
        System.out.println(Arrays.toString(solution.placedCoins(new int[][]{{0, 2}, {0, 6}, {1, 4}, {3, 5}, {7, 6}, {3, 6}, {1, 8}, {3, 1}, {9, 3}}, new int[]{63, 13, -6, 20, 56, -14, 61, 25, -99, 54})));

    }

    private int[] genParams2() {
        return new int[]{
                -5959, 602, -6457, 7055, -1462, 6347, 7226, -8422, -6088, 2997, -7909, 6433, 5217, 3294, -3792, 7463, 8538, -3811, 5009, 151, 5659, 4458, -1702, -1877, 2799, 9861, -9668, -1765, 2181, -8128, 7046, 9529, 6202, -8026, 6464, 1345, 121, 1922, 7274, -1227, -9914, 3025, 1046, -9368, -7368, 6205, -6342, 8091, -6732, -7620, 3276, 5136, 6871, 4823, -1885, -4005, -3974, -2725, -3845, -8508, 7201, -9566, -7236, -3386, 4021, 6793, -8759, 5066, 5879, -5171, 1011, 1242, 8536, -8405, -9646, -214, 2251, -9934, -8820, 6206, 1006, 1318, -9712, 7230, 5608, -4601, 9185, 346, 3056, 8913, -2454, -3445, -4295, 4802, -8852, -6121, -4538, -5580, -9246, -6462
        };
    }

    private int[][] genParams1() {
        int[][] params = new int[99][2];
        for (int i = 0; i < 99; i++) {
            params[i] = new int[]{0, i + 1};
        }
        return params;
    }
}
