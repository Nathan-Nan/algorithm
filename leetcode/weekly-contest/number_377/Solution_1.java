package number_377;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-377/problems/minimum-number-game/">...</a>
 */
public class Solution_1 {

    public int[] numberGame(int[] nums) {
        if (nums.length == 1) return nums;
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; ) {
            arr[i + 1] = nums[i];
            arr[i] = nums[i + 1];
            i += 2;
        }
        return arr;
    }
}
