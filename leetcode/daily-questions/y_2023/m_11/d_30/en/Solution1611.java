package y_2023.m_11.d_30.en;

/**
 * <a href="https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/?envType=daily-question&envId=2023-11-30">...</a>
 */
public class Solution1611 {
    public int minimumOneBitOperations(int n) {
        if (n < 2) return n;
        int ans = 0;
        while (n != 0) {
            ans ^= n;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1611 solution = new Solution1611();
        System.out.println(solution.minimumOneBitOperations(3));
        System.out.println(solution.minimumOneBitOperations(6));
    }
}
