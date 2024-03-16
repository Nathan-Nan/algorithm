package double_weekly.number_126.problem_2;

import java.util.*;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-126/problems/mark-elements-on-array-by-performing-queries/">...</a>
 */
public class Solution {

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int m = queries.length;
        long[] ans = new long[m];
        long sum = 0L;
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            queue.offer(new int[]{nums[i], i});
        }
        Set<Integer> marked = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int index = queries[i][0];
            int k = queries[i][1];
            long kSum = 0L;
            if (!marked.contains(index)) {
                marked.add(index);
                sum -= nums[index];
            }

            for (int j = 0; j < k; j++) {
                while (!queue.isEmpty() && marked.contains(queue.peek()[1])) {
                    queue.poll();
                }
                if (!queue.isEmpty()) {
                    int[] polled = queue.poll();
                    marked.add(polled[1]);
                    kSum += polled[0];
                }
            }
            sum -= kSum;
            ans[i] = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.unmarkedSumArray(new int[]{1, 2, 2, 1, 2, 3, 1}, new int[][]{{1, 2}, {3, 3}, {4, 2}})));
        System.out.println(Arrays.toString(solution.unmarkedSumArray(new int[]{1, 4, 2, 3}, new int[][]{{0, 1}})));
    }
}
