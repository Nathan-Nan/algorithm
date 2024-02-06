package y_2024.m_02.d_06.problem_lcp30;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/p0NxJO/description/?envType=daily-question&envId=2024-02-06">...</a>
 */
public class Solution {
    public int magicTower(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) {
            return -1;
        }
        int ans = 0;
        long hp = 1;
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            if (num < 0) {
                q.offer(num);
            }
            hp += num;
            if (hp < 1) {
                ans++;
                hp -= q.poll();
            }
        }
        return ans;
    }
}
