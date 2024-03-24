package y_2024.m_03.d_22.problem2617;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-visited-cells-in-a-grid/description/?envType=daily-question&envId=2024-03-22">...</a>
 */
public class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mn = 0;
        List<int[]>[] colStacks = new ArrayList[n]; // 每列的单调栈，为了能二分用 ArrayList
        Arrays.setAll(colStacks, i -> new ArrayList<int[]>());
        List<int[]> rowSt = new ArrayList<>(); // 行单调栈
        for (int i = m - 1; i >= 0; i--) {
            rowSt.clear();
            for (int j = n - 1; j >= 0; j--) {
                int g = grid[i][j];
                List<int[]> colSt = colStacks[j];
                mn = i < m - 1 || j < n - 1 ? Integer.MAX_VALUE : 1;
                if (g > 0) {
                    // 在单调栈上二分
                    int k = search(rowSt, j + g);
                    if (k < rowSt.size()) {
                        mn = rowSt.get(k)[0] + 1;
                    }
                    k = search(colSt, i + g);
                    if (k < colSt.size()) {
                        mn = Math.min(mn, colSt.get(k)[0] + 1);
                    }
                }
                if (mn < Integer.MAX_VALUE) {
                    // 插入单调栈
                    while (!rowSt.isEmpty() && mn <= rowSt.get(rowSt.size() - 1)[0]) {
                        rowSt.remove(rowSt.size() - 1);
                    }
                    rowSt.add(new int[]{mn, j});
                    while (!colSt.isEmpty() && mn <= colSt.get(colSt.size() - 1)[0]) {
                        colSt.remove(colSt.size() - 1);
                    }
                    colSt.add(new int[]{mn, i});
                }
            }
        }
        return mn < Integer.MAX_VALUE ? mn : -1; // 最后一个算出的 mn 就是 f[0][0]
    }

    // 开区间二分，见 https://www.bilibili.com/video/BV1AP41137w7/
    private int search(List<int[]> st, int target) {
        int left = -1, right = st.size(); // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            int mid = left + (right - left) / 2;
            if (st.get(mid)[1] <= target) {
                right = mid; // 范围缩小到 (left, mid)
            } else {
                left = mid; // 范围缩小到 (mid, right)
            }
        }
        return right;
    }
}
