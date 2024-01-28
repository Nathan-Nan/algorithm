package number_382.Problem_1;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-382/problems/number-of-changing-keys/">...</a>
 */
public class Solution {
    public int countKeyChanges(String s) {
        int ans = 0;
        s = s.toLowerCase();
        char last = '#';
        for (char c : s.toCharArray()) {
            if (last != '#' && last != c) {
                ans++;

            }
            last = c;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countKeyChanges("aAbBcC"));
        System.out.println(solution.countKeyChanges("AaAaAaaA"));
    }
}
