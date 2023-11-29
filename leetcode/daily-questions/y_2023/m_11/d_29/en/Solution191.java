package y_2023.m_11.d_29.en;

/**
 * <a href="https://leetcode.cn/problems/number-of-1-bits/description/">...</a>
 */
public class Solution191 {

    public int hammingWeight(int n) {
        if (n == 1)  return 1;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) ans++;
            n >>>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution191 solution = new Solution191();
        System.out.println(solution.hammingWeight(11));
    }
}
