package y_2024.m_02.d_28.problem_2673;

/**
 * <a href="https://leetcode.cn/problems/make-costs-of-paths-equal-in-a-binary-tree/description/?envType=daily-question&envId=2024-02-28">...</a>
 */
public class Solution {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n / 2; i > 0; i--) { // 从最后一个非叶节点开始算
            ans += Math.abs(cost[i * 2 - 1] - cost[i * 2]); // 两个子节点变成一样的
            cost[i - 1] += Math.max(cost[i * 2 - 1], cost[i * 2]); // 累加路径和
        }
        return ans;
    }
}
