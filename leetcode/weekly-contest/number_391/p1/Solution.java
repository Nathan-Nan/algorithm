package number_391.p1;

/**
 * <a href="https://leetcode.cn/problems/harshad-number/description/">...</a>
 */
public class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0, num = x;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum == 0) {
            return -1;
        }
        return x % sum == 0 ? sum : -1;
    }
}
