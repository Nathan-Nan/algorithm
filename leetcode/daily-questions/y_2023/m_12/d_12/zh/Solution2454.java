package y_2023.m_12.d_12.zh;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-iv/?envType=daily-question&envId=2023-12-12">...</a>
 */
public class Solution2454 {
    /**
     * 暴力解法
     * 时间复杂度 O(n^2)
     * 超时
     */
    public int[] secondGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    cnt++;
                }
                if (cnt == 2) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 单调栈解法
     * 时间复杂度 O(n)
     * AC
     */
    public int[] secondGreaterElement1(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        Deque<Integer> s = new ArrayDeque<>();
        Deque<Integer> t = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            while (!t.isEmpty() && nums[t.peek()] < num) {
                ans[t.pop()] = num;
            }
            Deque<Integer> p = new ArrayDeque<>();
            while (!s.isEmpty() && nums[s.peek()] < num) {
                p.push(s.pop());
            }
            while (!p.isEmpty()) {
                t.push(p.pop());
            }
            s.push(i);
        }
        return ans;
    }

}
