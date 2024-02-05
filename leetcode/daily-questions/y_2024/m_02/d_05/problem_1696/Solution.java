package y_2024.m_02.d_05.problem_1696;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/jump-game-vi/description/?envType=daily-question&envId=2024-02-05">...</a>
 */
public class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        for (int i = 1; i < n; i++) {
            // 1. 出
            if (!q.isEmpty() && q.peekFirst() < i - k) {
                q.pollFirst();
            }

            // 2. 转移
            if (!q.isEmpty()) {
                dp[i] = dp[q.peekFirst()] + nums[i];
            }

            // 3. 入
            while (!q.isEmpty() && dp[i] >= dp[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
        }
        return dp[n - 1];
    }
}
