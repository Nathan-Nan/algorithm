package double_weekly.number125.problem2;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-125/problems/minimum-operations-to-exceed-threshold-value-ii/">...</a>
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer((long) num);
        }
        int ans = 0;
        while (queue.size() >= 2) {
            if (queue.peek() >= k) {
                break;
            }
            long x = queue.poll();
            long y = queue.poll();
            queue.offer(x * 2 + y);
            ans++;
        }
        return ans;
    }
}
