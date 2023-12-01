package y_2023.m_12.d_01.zh;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/first-completely-painted-row-or-column/description/?envType=daily-question&envId=2023-12-01">...</a>
 */
public class Solution2661 {

    /**
     * 暴力遍历，AC，2100ms
     */
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int ans = 0, m = mat.length, n = mat[0].length;
        List<int[]> matlist = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matlist.add(new int[]{mat[i][j], i, j});
            }
        }
        matlist.sort(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < arr.length; i++) {
            int[] x = setColor(matlist, mat, arr[i]);
            if (complete(mat, x[0], x[1])) {
                return i;
            }
        }
        return ans;
    }

    private boolean complete(int[][] mat, int x, int y) {
        boolean rowComplete = true, colComplete = true;
        for (int[] row : mat) {
            if (row[y] != -1) {
                rowComplete = false;
                break;
            }
        }
        for (int i = 0; i < mat[0].length; i++) {
            if (mat[x][i] != -1) {
                colComplete = false;
                break;
            }
        }

        return rowComplete || colComplete;
    }

    private int[] setColor(List<int[]> matlist, int[][] mat, int num) {
        int x = 0, y = 0, l = 0, r = matlist.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            int[] arr = matlist.get(mid);
            if (arr[0] == num) {
                x = arr[1];
                y = arr[2];
                mat[x][y] = -1;
                break;
            } else if (arr[0] > num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{x, y};
    }

    /**
     * 空间换时间进行优化，AC，24ms
     */
    public int firstCompleteIndex1(int[] arr, int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] c1 = new int[n], c2 = new int[m];
        for (int i = 0; i < n * m; i++) {
            int[] info = map.get(arr[i]);
            int x = info[0], y = info[1];
            if (++c1[x] == m || ++c2[y] == n) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2661 solution = new Solution2661();
        System.out.println(solution.firstCompleteIndex(new int[]{2, 8, 7, 4, 1, 3, 5, 6, 9}, new int[][]{{3, 2, 5}, {1, 4, 6}, {8, 7, 9}}));
    }
}
