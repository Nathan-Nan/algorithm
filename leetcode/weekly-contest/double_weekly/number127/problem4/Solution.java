package double_weekly.number127.problem4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-127/problems/find-the-sum-of-subsequence-powers/">...</a>
 */
public class Solution {
    private int[] nums;
    private int k;
    private List<List<Integer>> subsequences;

    /**
     * 超时
     * @param nums
     * @param k
     * @return
     */
    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        this.nums = nums;
        this.k = k;
        this.subsequences = new ArrayList<>();
        long MOD = 1000000000 + 7;
        dfs(0, new PriorityQueue<>());
        long ans = 0;
        for (List<Integer> subsequence : subsequences) {
            // Collections.sort(subsequence);
            int power = Integer.MAX_VALUE / 2;
            for (int i = subsequence.size() - 1; i > 0; i--) {
                power = Math.min(power, Math.abs(subsequence.get(i) - subsequence.get(i - 1)));
            }
            ans = (ans + power) % MOD;
        }
        return (int) ans;
    }

    private void dfs(int curId, PriorityQueue<Integer> subsequence) {
        if (subsequence.size() == k) {
            subsequences.add(new ArrayList<>(subsequence));
            return;
        }
        if (curId == nums.length) {
            return;
        }
        // 选当前元素
        subsequence.add(nums[curId]);
        dfs(curId + 1, subsequence);
        subsequence.remove(subsequence.size() - 1);

        // 不选当前元素
        dfs(curId + 1, subsequence);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOfPowers(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 15));
    }
}
