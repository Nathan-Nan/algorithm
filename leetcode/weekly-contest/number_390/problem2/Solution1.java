package number_390.problem2;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-390/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/">...</a>
 * <p>
 * 通过
 */
public class Solution1 {
    public int minOperations(int k) {
        if (k == 1) return 0;
        int ans = k;
        for (int i = 1; i < k + 1; i++) {
            ans = Math.min(ans, i - 1 + Math.floorDiv(k - 1, i));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.minOperations(11));
        System.out.println(solution.minOperations(1));
        System.out.println(solution.minOperations(14));
        System.out.println(solution.minOperations(51));
    }
}
