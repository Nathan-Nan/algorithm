package y_2023.m_12.d_13.en;

/**
 * <a href="https://leetcode.cn/problems/special-positions-in-a-binary-matrix/description/">...</a>
 */
public class Solution1582 {

    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] += mat[i][j];
                cols[j] += mat[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
