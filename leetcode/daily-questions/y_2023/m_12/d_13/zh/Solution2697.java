package y_2023.m_12.d_13.zh;

/**
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-palindrome/description/?envType=daily-question&envId=2023-12-13">...</a>
 */
public class Solution2697 {
    public String makeSmallestPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] ans = s.toCharArray();
        while (l < r) {
            if (ans[l] != ans[r]) {
                ans[l] = ans[r] = (char) Math.min(ans[l], ans[r]);
            }
            l++;
            r--;
        }
        return String.valueOf(ans);
    }
}
