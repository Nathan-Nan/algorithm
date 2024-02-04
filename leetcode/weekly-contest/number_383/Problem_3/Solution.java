package number_383.Problem_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-the-grid-of-region-average/submissions/500428486/">...</a>
 * <p>
 * 性能差，比赛时 AC，但是后来再提交时超时
 */
public class Solution {
    private int[][] image;
    private int threshold;
    private Map<String, List<Integer>> map;
    private int m;
    private int n;

    public int[][] resultGrid(int[][] image, int threshold) {
        this.image = image;
        this.threshold = threshold;
        this.map = new HashMap<>();
        this.m = image.length;
        this.n = image[0].length;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                getStrength(i, j);
            }
        }
        return getResult();
    }

    private void getStrength(int row, int col) {
        int sum = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (i - 1 >= row && Math.abs(image[i][j] - image[i - 1][j]) > threshold) {
                    return;
                }
                if (j - 1 >= col && Math.abs(image[i][j] - image[i][j - 1]) > threshold) {
                    return;
                }
                sum += image[i][j];
            }
        }
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                map.computeIfAbsent(i + "_" + j, v -> new ArrayList<>()).add(sum / 9);
            }
        }
    }

    private int[][] getResult() {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(i + "_" + j)) {
                    result[i][j] = (int) map.get(i + "_" + j).stream().mapToInt(Integer::intValue).average().orElse(0d);
                } else {
                    result[i][j] = image[i][j];
                }
            }
        }
        return result;
    }
}
