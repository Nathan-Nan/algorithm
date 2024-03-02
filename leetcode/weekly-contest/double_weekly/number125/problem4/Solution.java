package double_weekly.number125.problem4;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-125/problems/find-the-maximum-sum-of-node-values/">...</a>
 */
public class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long re = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            re += num;
            heap.add((num ^ k) - num);
        }
        while (heap.size() > 1) {
            int a = heap.poll(), b = heap.poll();
            if (a + b > 0) re += a + b;
            else break;
        }
        return re;
    }
}
