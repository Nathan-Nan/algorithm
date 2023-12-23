package double_weekly.number_120;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-120/problems/count-the-number-of-incremovable-subarrays-ii/">...</a>
 */
public class Solution_3 {
    public long incremovableSubarrayCount(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int a = 1, b = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) {
                a++;
            } else break;
        }
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                b++;
            } else break;
        }
        if (n == 1) return 1;
        if (a == n) return n * (n + 1L) / 2;
        for (int i = 0, j = n - b; i < a; ++i) {
            while (j < n && nums[i] >= nums[j]) ++j;
            ans += n - j + 1;
        }
        ans += b + 1;
        return ans;
    }
}
