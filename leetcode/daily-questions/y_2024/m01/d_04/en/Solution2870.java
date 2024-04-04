package y_2024.m01.d_04.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/?envType=daily-question&envId=2024-01-04">...</a>
 */
public class Solution2870 {

    /**
     * 解法一：统计出现次数
     */
    public int minOperations(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int ans = 0;
        for (Integer cnt : map.values()) {
            if (cnt == 1) {
                return -1;
            }
            ans += (cnt + 2) / 3;
        }
        return ans;
    }

    /**
     * 解法二：排序
     */
    public int minOperations1(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, s = 0;
        while (s < nums.length) {
            int e = s;
            while (e < nums.length && nums[e] == nums[s]) {
                e++;
            }
            int cnt = e - s;
            if (cnt == 1) {
                return -1;
            }
            ans += (cnt + 2) / 3;
            s = e;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2870 solution = new Solution2870();
        System.out.println(solution.minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
    }
}
