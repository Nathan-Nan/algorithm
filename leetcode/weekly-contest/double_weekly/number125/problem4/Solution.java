package double_weekly.number125.problem4;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-125/problems/find-the-maximum-sum-of-node-values/">...</a>
 */
public class Solution {

    private int[][] edges;
    private int k;
    private int edgeCnt;
    private int[] nums;
    private long ans = 0L;

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

    private void backTrace(int curIdx, long sum) {
        if (curIdx == edgeCnt) {
            ans = Math.max(ans, sum);
            return;
        }
        backTrace(curIdx + 1, sum);

        int u = edges[curIdx][0], v = edges[curIdx][1];
        int uRaw = nums[u], uXOR = uRaw ^ k;
        int vRaw = nums[v], vXOR = vRaw ^ k;
        // 异或
        nums[u] = uXOR;
        nums[v] = vXOR;
        backTrace(curIdx + 1, sum + (uXOR - uRaw) + (vXOR - vRaw));
        // 回溯
        nums[u] = uRaw;
        nums[v] = vRaw;
    }
}
