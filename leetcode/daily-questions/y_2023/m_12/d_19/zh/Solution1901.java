package y_2023.m_12.d_19.zh;

/**
 * <a href="https://leetcode.cn/problems/find-a-peak-element-ii/description/?envType=daily-question&envId=2023-12-19">...</a>
 */
public class Solution1901 {

    public int[] findPeakGrid(int[][] mat) {
        int left = 0, right = mat.length - 2;
        while (left <= right) {
            int i = (left + right) >>> 1;
            int j = indexOfMax(mat[i]);
            if (mat[i][j] > mat[i + 1][j]) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return new int[]{left, indexOfMax(mat[left])};
    }

    private int indexOfMax(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[idx] < nums[i]) {
                idx = i;
            }
        }
        return idx;
    }
}
