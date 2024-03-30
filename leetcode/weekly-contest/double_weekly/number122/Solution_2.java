package double_weekly.number122;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-122/problems/find-if-array-can-be-sorted/">...</a>
 */
public class Solution_2 {
    public boolean canSortArray(int[] nums) {
        if (nums.length == 1) return true;
        for (int i = 0; i < nums.length; i++) {
            int cnt = Integer.bitCount(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j] && Integer.bitCount(nums[j]) != cnt) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        System.out.println(solution.canSortArray(new int[]{8, 4, 2, 30, 15}));
        System.out.println(solution.canSortArray(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.canSortArray(new int[]{3, 16, 8, 4, 2}));
    }
}
