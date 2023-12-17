package number_376;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-376/problems/minimum-cost-to-make-array-equalindromic/">...</a>
 */
public class Solution_3 {
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, middle = -1;
        if (n % 2 == 1) {
            middle = nums[n / 2];
        } else {
            middle = nums[n / 2] + nums[n / 2] >> 1;
        }
        long ans = 0L;
        if (isHomogeneous(middle)) {
            for (int num : nums) {
                ans += Math.abs(num - middle);
            }
            return ans;
        }
        int m1 = middle, m2 = middle;
        for (int i = middle; i >= 0; i--) {
            if (isHomogeneous(i)) {
                m1 = i;
                break;
            }
        }
        for (int i = middle; ; i++) {
            if (isHomogeneous(i)) {
                m2 = i;
                break;
            }
        }
        long ans1 = 0L, ans2 = 0L;
        for (int num : nums) {
            ans1 += Math.abs(num - m1);
            ans2 += Math.abs(num - m2);
        }
        return Math.min(ans1, ans2);
    }

    private boolean isHomogeneous(int num) {
        String s = String.valueOf(num);
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        System.out.println(solution.minimumCost(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.minimumCost(new int[]{10, 12, 13, 14, 15}));
        System.out.println(solution.minimumCost(new int[]{22, 33, 22, 33, 22}));
    }
}
