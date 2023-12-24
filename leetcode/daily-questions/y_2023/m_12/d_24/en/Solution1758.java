package y_2023.m_12.d_24.en;

/**
 * <a href="https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description/?envType=daily-question&envId=2023-12-24">...</a>
 */
public class Solution1758 {

    /**
     * 解法1
     */
    public int minOperations1(String s) {
        int ans1 = 0, ans2 = 0;
        char[] a = s.toCharArray();
        char[] c1 = new char[a.length];
        char[] c2 = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                c1[i] = '0';
                c2[i] = '1';
            } else {
                c1[i] = '1';
                c2[i] = '0';
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != c1[i]) {
                ans1++;
            }
            if (a[i] != c2[i]) {
                ans2++;
            }
        }
        return Math.min(ans1, ans2);
    }


    /**
     * 解法er
     */
    public int minOperations(String s) {
        int ans1 = 0, ans2 = 0;
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                ans1 += a[i] == '1' ? 0 : 1;
                ans2 += a[i] == '1' ? 1 : 0;
            } else {
                ans1 += a[i] == '0' ? 0 : 1;
                ans2 += a[i] == '0' ? 1 : 0;
            }
        }
        return Math.min(ans1, ans2);
    }

    public static void main(String[] args) {
        Solution1758 solution = new Solution1758();
        System.out.println(solution.minOperations("10010100"));
    }
}
