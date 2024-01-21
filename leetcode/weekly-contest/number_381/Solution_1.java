package number_381;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-381/problems/minimum-number-of-pushes-to-type-word-i/">...</a>
 */
public class Solution_1 {
    public int minimumPushes(String word) {
        if (word.length() < 9) return word.length();
        int n = word.length(), a = n / 8, b = n % 8;
        return 8 * ((1 + a) * a / 2) + b * (1 + a);
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(solution.minimumPushes("abcde"));
        System.out.println(solution.minimumPushes("xycdefghij"));
        System.out.println(solution.minimumPushes("abhrlngxyjkezwcm"));
    }
}
