package double_weekly.number_121;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-121/problems/count-the-number-of-powerful-integers/">...</a>
 */
public class Solution_4 {

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long suffix = Long.parseLong(s);
        if (suffix > finish) {
            return 0;
        }
        long factor = 1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            factor *= 10;
        }
        long newStart = start / factor, newFinish = finish / factor;
        if (start % factor > suffix) {
            newStart++;
        }
        if (finish % factor < suffix) {
            newFinish--;
        }
        int[] digits = new int[limit + 1];
        for (int i = 0; i <= limit; i++) {
            digits[i] = i;
        }
        long count1 = atMostNGivenDigitSet(digits, newStart - 1);
        long count2 = atMostNGivenDigitSet(digits, newFinish);
        return count2 - count1;
    }

    public long atMostNGivenDigitSet(int[] digits, long n) {
        if (n < 0) {
            return 0;
        }
        int m = getLength(n);
        long factor = 1;
        for (int i = 1; i < m; i++) {
            factor *= 10;
        }
        int digitsCount = digits.length;
        long[][] dp = new long[m + 1][2];
        dp[0][1] = 1;
        for (int i = 1; i <= m; i++, factor /= 10) {
            int curr = (int) (n / factor % 10);
            for (int digit : digits) {
                if (digit < curr) {
                    dp[i][0] += dp[i - 1][1];
                } else if (digit == curr) {
                    dp[i][1] += dp[i - 1][1];
                } else {
                    break;
                }
            }
            if (i > 1) {
                dp[i][0] += dp[i - 1][0] * digitsCount;
            }
        }
        return dp[m][0] + dp[m][1];
    }

    public int getLength(long n) {
        int length = 0;
        while (n > 0) {
            n /= 10;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        Solution_4 solution = new Solution_4();
        System.out.println(solution.numberOfPowerfulInt(1, 6000, 4, "124"));
        System.out.println(solution.numberOfPowerfulInt(15, 215, 6, "10"));
        System.out.println(solution.numberOfPowerfulInt(1000, 2000, 4, "3000"));
        System.out.println(solution.numberOfPowerfulInt(141, 148, 9, "9"));
    }
}
