package y_2023.m_12.d_19.en;

/**
 * <a href="https://leetcode.cn/problems/image-smoother/description/">...</a>
 */
public class Solution661 {
    /**
     * 暴力解法
     * O(m * n * C)
     */
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0, sum = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            num++;
                            sum += img[x][y];
                        }
                    }
                }
                ret[i][j] = sum / num;
            }
        }
        return ret;
    }

    /**
     * 二维前缀和
     * O(m * n)
     */
    public int[][] imageSmoother1(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] s = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = Math.max(0, j - 1);
                int right = Math.min(n - 1, j + 1);

                int top = Math.max(0, i - 1);
                int down = Math.min(m - 1, i + 1);
                int cnt = (right - left + 1) * (down - top + 1);
                int val = s[down + 1][right + 1] - s[top][right + 1] - s[down + 1][left] + s[top][left];
                res[i][j] = val / cnt;
            }
        }
        return res;
    }
}
