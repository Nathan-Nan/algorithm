package number_390.problem2;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-390/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/">...</a>
 * <p>
 * 通过
 */
public class Solution2 {
    public int minOperations(int k) {
        int rt = (int) Math.max(1, Math.sqrt(k - 1));
        return Math.min(rt + Math.floorDiv(k - 1, rt) - 1, rt + Math.floorDiv(k - 1, rt + 1));
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.minOperations(11));
        System.out.println(solution.minOperations(1));
        System.out.println(solution.minOperations(14));
        System.out.println(solution.minOperations(51));
    }
}
