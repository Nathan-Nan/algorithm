package number398.p2;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-398/problems/special-array-ii/">...</a>
 */
public class Solution {

    public boolean[] isArraySpecial_Timeout(int[] nums, int[][] queries) {
        int[] flags = Arrays.stream(nums).map(i -> i & 1).toArray();
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            boolean res = true;
            for (int j = queries[i][0] + 1; j < queries[i][1] + 1; j++) {
                if (flags[j] == flags[j - 1]) {
                    res = false;
                    break;
                }
            }
            ans[i] = res;
        }
        return ans;
    }

    /**
     * AC
     *
     * @param nums
     * @param queries
     * @return
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] flags = new int[nums.length];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            flags[i] = nums[i] & 1;
            if (i > 0 && flags[i - 1] == flags[i]) {
                treeSet.add(i);
            }
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            boolean res = true;
            int from = queries[i][0], to = queries[i][1];
            Integer toFloor = treeSet.floor(to);
            Integer fromCeiling = treeSet.ceiling(from);
            if (toFloor != null && toFloor > from) {
                res = false;
            }
            if (fromCeiling != null && fromCeiling <= to && fromCeiling > from) {
                res = false;
            }
            ans[i] = res;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.isArraySpecial(new int[]{3, 4, 1, 2, 6}, new int[][]{{0, 4}})));
        System.out.println(Arrays.toString(solution.isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}})));
    }
}
