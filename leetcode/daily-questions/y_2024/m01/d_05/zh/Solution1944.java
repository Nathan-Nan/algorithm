package y_2024.m01.d_05.zh;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/number-of-visible-people-in-a-queue/description/?envType=daily-question&envId=2024-01-05">...</a>
 */
public class Solution1944 {
    /**
     * 单调栈，从左往右暴力枚举
     * 超时
     */
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = i + 1; j < n; j++) {
                if (stack.isEmpty() || stack.peek() < Math.min(heights[j], heights[i])) {
                    stack.push(heights[j]);
                }
            }
            ans[i] = stack.size();
        }
        return ans;
    }
    /**
     * 单调栈，从右往左遍历，及时去掉无用数据（即被挡住的身高）
     * AC
     */
    public int[] canSeePersonsCount1(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                ans[i]++;
            }
            if (!stack.isEmpty()) {
                ans[i]++;
            }
            stack.push(heights[i]);
        }
        return ans;
    }
}
