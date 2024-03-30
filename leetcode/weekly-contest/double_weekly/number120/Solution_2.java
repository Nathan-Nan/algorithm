package double_weekly.number120;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-120/problems/find-polygon-with-the-largest-perimeter/">...</a>
 */
public class Solution_2 {

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = Arrays.stream(nums).mapToLong(i -> i).sum();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i >= 2 && sum - nums[i] > nums[i]) {
                return sum;
            }
            sum -= nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        System.out.println(solution.largestPerimeter(new int[]{5, 5, 5}));
        System.out.println(solution.largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3}));
        System.out.println(solution.largestPerimeter(new int[]{5, 5, 50}));
    }
}
