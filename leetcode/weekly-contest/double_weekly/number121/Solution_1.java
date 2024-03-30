package double_weekly.number121;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-121/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/">...</a>
 */
public class Solution_1 {
    public int missingInteger(int[] nums) {
        boolean[] has = new boolean[51];
        for (int num : nums) {
            has[num] = true;
        }
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                break;
            }
            ans += nums[i];
        }
        while (ans <= 50 && has[ans]) {
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(solution.missingInteger(new int[]{37, 1, 2, 9, 5, 8, 5, 2, 9, 4}));
    }
}
