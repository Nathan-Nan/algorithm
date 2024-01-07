package number_379;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-379/problems/maximum-size-of-a-set-after-removals/">...</a>
 */
public class Solution_3 {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length, half = n / 2;
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> set = new HashSet<Integer>() {{
            addAll(set1);
            addAll(set2);
        }};
        return Math.min(n, Math.min(set.size(), Math.min(half, set1.size()) + Math.min(half, set2.size())));
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        System.out.println(solution.maximumSetSize(new int[]{1, 2, 1, 2}, new int[]{1, 1, 1, 1}));
        System.out.println(solution.maximumSetSize(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 2, 3, 2, 3}));
        System.out.println(solution.maximumSetSize(new int[]{1, 1, 2, 2, 3, 3}, new int[]{4, 4, 5, 5, 6, 6}));
        System.out.println(solution.maximumSetSize(new int[]{1, 1, 2, 2, 1, 1}, new int[]{1, 3, 2, 2, 2, 1}));
        System.out.println(solution.maximumSetSize(new int[]{1, 2, 1, 1}, new int[]{1, 2, 3, 4}));
    }
}
