package double_weekly.number127.problem1;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-127/problems/shortest-subarray-with-or-at-least-k-i/">...</a>
 */
public class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                int or = nums[i];
                for (int l = i + 1; l < j; l++) {
                    or |= nums[l];
                }
                if (or >= k) {
                    ans = Math.min(ans, j - i);
                }
            }
        }
        return ans == nums.length + 1 ? -1 : ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        System.out.println(solution.minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 2}, 0));
    }
}
