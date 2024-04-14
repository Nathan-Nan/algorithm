package number393.p2;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-393/problems/maximum-prime-difference/">...</a>
 */
public class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < nums.length) {
            if (isPrime(nums[l])) {
                break;
            }
            l++;
        }
        while (r < nums.length) {
            if (isPrime(nums[r])) {
                break;
            }
            r--;
        }
        return r - l;
    }

    private static boolean isPrime(int src) {
        double sqrt = Math.sqrt(src);
        if (src < 2) {
            return false;
        }
        if (src == 2 || src == 3) {
            return true;
        }
        if (src % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= sqrt; i+=2) {
            if (src % i == 0) {
                return false;
            }
        }
        return true;
    }
}
