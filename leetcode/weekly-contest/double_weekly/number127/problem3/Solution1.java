package double_weekly.number127.problem3;

/**
 * 通过
 */
public class Solution1 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int v = 0;
        for (int num : nums) {
            v |= num;
        }
        if (v < k) {
            return -1;
        }
        int[][] sums = new int[n + 1][31];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 31; j++) {
                sums[i + 1][j] = sums[i][j] + ((nums[i] >> j) & 1);
            }
        }
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            boolean b = false;
            for (int i = mid; i <= n; i++) {
                int t = 0;
                for (int j = 0; j < 31; j++) {
                    if (sums[i][j] - sums[i - mid][j] > 0) {
                        t += 1 << j;
                    }
                }
                if (t >= k) {
                    b = true;
                    break;
                }
            }
            if (b) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
