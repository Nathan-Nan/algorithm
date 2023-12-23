package double_weekly.number_120;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-120/problems/count-the-number-of-incremovable-subarrays-i/">...</a>
 */
public class Solution_1 {
    /**
     * 暴力解法
     * AC
     */
    public int incremovableSubarrayCount(int[] nums) {
        if (nums.length == 1) return 1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (check(nums, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean check(int[] nums, int i, int j) {
        int last = -1;
        for (int k = 0; k < nums.length; k++) {
            if (k < i || k > j) {
                if (last >= nums[k]) {
                    return false;
                }
                last = nums[k];
            }
        }
        return true;
    }

    public int incremovableSubarrayCount1(int[] nums) {
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
        if (a == n) return n * (n + 1) / 2;
        for (int i = 0, j = n - b; i < a; ++i) {
            while (j < n && nums[i] >= nums[j]) ++j;
            ans += n - j + 1;
        }
        ans += b + 1;
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(solution.incremovableSubarrayCount(new int[]{1, 2, 3, 4}));
        System.out.println(solution.incremovableSubarrayCount(new int[]{6, 5, 7, 8}));
        System.out.println(solution.incremovableSubarrayCount(new int[]{8, 7, 6, 6}));
        System.out.println(solution.incremovableSubarrayCount1(new int[]{1, 2, 3, 4}));
        System.out.println(solution.incremovableSubarrayCount1(new int[]{6, 5, 7, 8}));
        System.out.println(solution.incremovableSubarrayCount1(new int[]{8, 7, 6, 6}));
    }
}
