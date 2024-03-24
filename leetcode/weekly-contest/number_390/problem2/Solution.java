package number_390.problem2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-390/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/">...</a>
 * <p>
 * 超时
 */
public class Solution {
    public int minOperations(int k) {
        if (k == 1) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.offer(1);
        return backTrace(k, queue, 1);
    }

    private int backTrace(int k, PriorityQueue<Integer> queue, int sum) {
        if (sum >= k) return 0;
        Integer max = queue.peek();
        queue.offer(max);
        int ans = backTrace(k, queue, sum + max);
        queue.poll();

        Integer poll = queue.poll();
        queue.offer(poll + 1);
        ans = Math.min(ans, backTrace(k, queue, sum + 1));
        queue.offer(queue.poll() - 1);

        return ans + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(11));
        System.out.println(solution.minOperations(1));
        System.out.println(solution.minOperations(14));
        System.out.println(solution.minOperations(51));
    }
}
