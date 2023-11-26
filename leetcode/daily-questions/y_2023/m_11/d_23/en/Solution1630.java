package y_2023.m_11.d_23.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/arithmetic-subarrays/?envType=daily-question&envId=2023-11-23">...</a>
 */
public class Solution1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> result = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            result.add(i, isValidArithmeticSubarrays(nums, l[i], r[i] + 1));
        }
        return result;
    }

    private Boolean isValidArithmeticSubarrays(int[] nums, int s, int e) {
        int[] array = new int[e - s];
        for (int k = s; k < e; k++) {
            array[k - s] = nums[k];
        }
        Arrays.sort(array);
        int sub = array[1] - array[0];
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] != sub) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1630 solution = new Solution1630();
        System.out.println(solution.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));
        System.out.println(solution.checkArithmeticSubarrays(new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10}, new int[]{0, 1, 6, 4, 8, 7}, new int[]{4, 4, 9, 7, 9, 10}));
    }
}
