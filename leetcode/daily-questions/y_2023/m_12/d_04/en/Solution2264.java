package y_2023.m_12.d_04.en;

/**
 * <a href="https://leetcode.cn/problems/largest-3-same-digit-number-in-string/description/">...</a>
 */
public class Solution2264 {

    public String largestGoodInteger(String num) {
        String ans = "";
        int l = 0, r = l + 1;
        while (r < num.length()) {
            if (r - l + 1 == 3 && num.charAt(l) == num.charAt(r)) {
                String cur = num.substring(l, r + 1);
                ans = ans.compareTo(cur) >= 0 ? ans : cur;
            }
            if (num.charAt(l) != num.charAt(r)) {
                l = r;
            }
            r++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution2264 solution = new Solution2264();
        System.out.println(solution.largestGoodInteger("6777133339"));
        System.out.println(solution.largestGoodInteger("2300019"));
        System.out.println(solution.largestGoodInteger("42352338"));
    }
}
