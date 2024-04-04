package y_2024.m01.d_04.zh;

/**
 * <a href="https://leetcode.cn/problems/maximum-rows-covered-by-columns/description/?envType=daily-question&envId=2024-01-04">...</a>
 */
public class Solution2397 {

    /**
     * 解法一：二进制枚举
     */
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        int[] mask = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mask[i] |= matrix[i][j] << j;
            }
        }

        int ans = 0;
        for (int subset = 0; subset < (1 << n); subset++) {
            if (Integer.bitCount(subset) == numSelect) {
                int coveredRows = 0;
                for (int row : mask) {
                    if ((row & subset) == row) {
                        coveredRows++;
                    }
                }
                ans = Math.max(ans, coveredRows);
            }
        }
        return ans;
    }

    /**
     * 解法二：暴力枚举DFS + 回溯
     */
    int res = 0;

    public int maximumRows1(int[][] matrix, int numSelect) {
        backTrice(matrix, new boolean[matrix[0].length], 0, numSelect);
        return res;
    }

    /**
     * @param matrix   矩阵
     * @param selected 记录哪些列被选了
     * @param cur      当前列
     * @param select   还剩多少次选择机会
     */
    private void backTrice(int[][] matrix, boolean[] selected, int cur, int select) {
        // 下标越界但还没有选择完，此时为无效枚举，直接 return
        if (cur == matrix[0].length && select != 0) return;
        // 已选择完，此时为有效枚举，统计覆盖行数，更新 res
        if (select == 0) {
            int cnt = 0;
            for (int[] row : matrix) {
                boolean flag = true;
                for (int i = 0; i < row.length; i++) {
                    if (!selected[i] && row[i] == 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
            return;
        }
        // 不选当前列
        backTrice(matrix, selected, cur + 1, select);
        // 选择当前列
        selected[cur] = true;
        backTrice(matrix, selected, cur + 1, select - 1);
        // 回溯
        selected[cur] = false;
    }
}
