package double_weekly.number126.problem_1;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-126/problems/find-the-sum-of-encrypted-integers/">...</a>
 */
public class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += encrypt(num);
        }
        return sum;
    }

    private int encrypt(int num) {
        String s = String.valueOf(num);
        StringBuilder builder = new StringBuilder();
        int max = -1;
        for (char c : s.toCharArray()) {
            max = Math.max(max, c - '0');
        }
        for (int i = 0; i < s.length(); i++) {
            builder.append(max);
        }
        return Integer.parseInt(builder.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOfEncryptedInt(new int[]{1, 2, 3}));
        System.out.println(solution.sumOfEncryptedInt(new int[]{10, 21, 31}));
        System.out.println(solution.sumOfEncryptedInt(new int[]{109}));
    }
}
