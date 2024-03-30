package double_weekly.number127.problem3;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-127/problems/shortest-subarray-with-or-at-least-k-ii/">...</a>
 */
public class Solution {
    /**
     * 超时
     * @param nums
     * @param k
     * @return
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        int max = nums[0];
        for (int i = 1; i < n + 1; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
            max = Math.max(max, nums[i - 1]);
        }
        if (max > k) {
            return 1;
        }
        int ans = n + 1;
        for (int i = 0; i < prefixSum.length; i++) {
            if (prefixSum[i] < k) {
                continue;
            }
            for (int j = i; j >= 0; j--) {
                if (prefixSum[i] - prefixSum[j] >= k) {
                    ans = Math.min(i - j , ans);
                    break;
                }
            }
        }
        return ans == n + 1 ? -1 : ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        System.out.println(solution.minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 2}, 0));
    }
}
