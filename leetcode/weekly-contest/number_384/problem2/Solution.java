package number_384.problem2;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-384/problems/number-of-subarrays-that-match-a-pattern-i/">...</a>
 */
public class Solution {
    private int[] nums;
    private int[] pattern;
    private int n;
    private int m;

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        this.n = nums.length;
        this.m = pattern.length;
        this.nums = nums;
        this.pattern = pattern;
        int ans = 0;
        for (int i = 0; i < n - m; i++) {
            if (check(i, i + m)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean check(int left, int right) {
        int k = 0;
        for (int i = left; i < right; i++) {
            if (pattern[k] == 1 && nums[i + 1] > nums[i]) {
                k++;
                continue;
            }
            if (pattern[k] == 0 && nums[i + 1] == nums[i]) {
                k++;
                continue;
            }
            if (pattern[k] == -1 && nums[i + 1] < nums[i]) {
                k++;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countMatchingSubarrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1}));
        System.out.println(solution.countMatchingSubarrays(new int[]{1, 4, 4, 1, 3, 5, 5, 3}, new int[]{1, 0, -1}));
    }
}
