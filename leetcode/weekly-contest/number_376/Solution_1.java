package number_376;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-376/problems/find-missing-and-repeated-values/">...</a>
 */
public class Solution_1 {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] nums = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[grid[i][j]]++;
            }
        }
        int repeated = -1, d = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                repeated = i;
            }
            if (nums[i] == 0) {
                d = i;
            }
        }
        return new int[]{repeated, d};
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(Arrays.toString(solution.findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})));
        System.out.println(Arrays.toString(solution.findMissingAndRepeatedValues(new int[][]{{9, 1, 7}, {8, 9, 2}, {3, 4, 6}})));
    }
}
