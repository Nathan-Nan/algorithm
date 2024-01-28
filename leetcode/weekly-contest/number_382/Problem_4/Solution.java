package number_382.Problem_4;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-382/problems/minimize-or-of-remaining-elements-using-operations/">...</a>
 */
public class Solution {
    int mask = (1 << 30) - 1;

    private boolean check(int x, int[] nums, int k) {
        int s = mask;
        int cnt = 0;
        for (int v : nums) {
            s &= v;
            if ((s & x) == s) {
                cnt += 1;
                if (cnt >= nums.length - k) {
                    return true;
                }
                s = mask;
            }
        }
        return false;
    }

    public int minOrAfterOperations(int[] nums, int k) {
        int left = 0, right = mask;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOrAfterOperations(new int[]{3, 5, 3, 2, 7}, 2));
        System.out.println(solution.minOrAfterOperations(new int[]{7, 3, 15, 14, 2, 8}, 4));
        System.out.println(solution.minOrAfterOperations(new int[]{10, 7, 10, 3, 9, 14, 9, 4}, 1));
    }
}
