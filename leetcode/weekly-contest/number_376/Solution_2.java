package number_376;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-376/problems/divide-array-into-arrays-with-max-difference/">...</a>
 */
public class Solution_2 {

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if (n % 3 != 0) {
            return new int[][]{};
        }
        Arrays.sort(nums);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ) {
            if (nums[i + 2] - nums[i] <= k) {
                list.add(new int[]{nums[i], nums[i + 1], nums[i + 2]});
                i += 3;
            } else {
                i++;
            }
        }

        if (list.size() == n / 3) {
            return list.toArray(new int[0][]);
        }
        return new int[][]{};
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        System.out.println(Arrays.deepToString(solution.divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2)));
        System.out.println(Arrays.deepToString(solution.divideArray(new int[]{1, 3, 3, 2, 7, 3}, 2)));
    }
}
