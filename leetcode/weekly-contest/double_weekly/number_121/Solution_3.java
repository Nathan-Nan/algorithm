package double_weekly.number_121;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-121/problems/minimum-number-of-operations-to-make-x-and-y-equal/">...</a>
 */
public class Solution_3 {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y) return y - x;
        int ans = Math.abs(x - y);
        int mod5 = x % 5, mod11 = x % 11;
        ans = Math.min(ans, minimumOperationsToMakeEqual(x / 5, y) + 1 + mod5);
        ans = Math.min(ans, minimumOperationsToMakeEqual(x / 5 + 1, y) + 1 + (5 - mod5));
        ans = Math.min(ans, minimumOperationsToMakeEqual(x / 11, y) + 1 + mod11);
        ans = Math.min(ans, minimumOperationsToMakeEqual(x / 11 + 1, y) + 1 + (11 - mod11));
        return ans;
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        System.out.println(solution.minimumOperationsToMakeEqual(26, 1));
        System.out.println(solution.minimumOperationsToMakeEqual(54, 2));
        System.out.println(solution.minimumOperationsToMakeEqual(25, 30));
    }
}
