package double_weekly.number124.problem_3;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-124/problems/maximum-number-of-operations-with-the-same-score-ii/">...</a>
 */
public class Solution {
    private int[] nums;
    private Map<String, Integer> cache;

    public int maxOperations(int[] nums) {
        int left = 0, right = nums.length - 1;
        this.nums = nums;
        this.cache = new HashMap<>();
        int ans = dfs(left + 2, right, nums[left] + nums[left + 1]);
        ans = Math.max(dfs(left, right - 2, nums[right - 1] + nums[right]), ans);
        ans = Math.max(dfs(left + 1, right - 1, nums[left] + nums[right]), ans);
        return ans + 1;
    }

    private int dfs(int left, int right, int score) {
        if (right <= left) {
            return 0;
        }
        if (right - left == 1) {
            return score == nums[left] + nums[right] ? 1 : 0;
        }
        String key = left + "-" + right + "-" + score;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int ans = 0;
        if (score == nums[left] + nums[left + 1]) {
            ans = Math.max(ans, dfs(left + 2, right, score) + 1);
        }
        if (score == nums[right - 1] + nums[right]) {
            ans = Math.max(ans, dfs(left, right - 2, score) + 1);
        }
        if (score == nums[left] + nums[right]) {
            ans = Math.max(ans, dfs(left + 1, right - 1, score) + 1);
        }
        cache.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxOperations(new int[]{3, 2, 1, 2, 3, 4}));
        System.out.println(solution.maxOperations(new int[]{3, 2, 6, 1, 4}));
        System.out.println(solution.maxOperations(new int[]{1, 9, 7, 3, 2, 7, 4, 12, 2, 6}));
    }
}
