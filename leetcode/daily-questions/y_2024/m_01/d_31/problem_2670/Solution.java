package y_2024.m_01.d_31.problem_2670;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/find-the-distinct-difference-array/description/?envType=daily-question&envId=2024-01-31">...</a>
 */
public class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] prefix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            prefix[i] = set.size();
        }
        set.clear();
        int[] suffix = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = set.size();
            set.add(nums[i]);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] - suffix[i];
        }
        return res;
    }
}
