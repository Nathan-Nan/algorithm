package double_weekly.number_121;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-121/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/">...</a>
 */
public class Solution_2 {
    public int minOperations(int[] nums, int k) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return Integer.bitCount(a ^ k);
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        System.out.println(solution.minOperations(new int[]{2, 1, 3, 4}, 1));
        System.out.println(solution.minOperations(new int[]{2, 0, 2, 0}, 0));
    }
}
