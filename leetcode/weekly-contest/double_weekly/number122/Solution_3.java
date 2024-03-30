package double_weekly.number122;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-122/problems/minimize-length-of-array-using-operations/">...</a>
 */
public class Solution_3 {
    public int minimumArrayLength(int[] nums) {
        if (nums.length == 1) return 1;
        int min = Integer.MAX_VALUE, cnt = 0;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            if (num == min) cnt++;
        }
        for (int num : nums) {
            if (num % min != 0) return 1;
        }
        return (cnt + 1) / 2;
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        System.out.println(solution.minimumArrayLength(new int[]{1, 4, 3, 1}));
        System.out.println(solution.minimumArrayLength(new int[]{5, 5, 5, 10, 5}));
        System.out.println(solution.minimumArrayLength(new int[]{2, 3, 4}));
        System.out.println(solution.minimumArrayLength(new int[]{4, 4, 4}));
        System.out.println(solution.minimumArrayLength(new int[]{5, 2, 2, 2, 9, 10}));
    }
}
