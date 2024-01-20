package double_weekly.number_122;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-122/problems/divide-an-array-into-subarrays-with-minimum-cost-i/">...</a>
 */
public class Solution_1 {
    public int minimumCost(int[] nums) {
        int a = Math.min(nums[1], nums[2]), b = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] < a) {
                b = a;
                a = nums[i];
            } else if (nums[i] < b) {
                b = nums[i];
            }
        }
        return nums[0] + a + b;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(solution.minimumCost(new int[]{1, 2, 3, 12}));
        System.out.println(solution.minimumCost(new int[]{5, 4, 3}));
        System.out.println(solution.minimumCost(new int[]{10, 3, 1, 1}));
    }
}
