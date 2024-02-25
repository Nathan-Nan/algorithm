package number_386.problem1;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-386/problems/split-the-array/">...</a>
 */
public class Solution {

    public boolean isPossibleToSplit(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            if (++cnt[num] > 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPossibleToSplit(new int[]{2, 10, 2, 7, 8, 9, 7, 6, 6, 9}));
        System.out.println(solution.isPossibleToSplit(new int[]{8, 9, 8, 5, 9, 3, 3, 1, 2, 1}));
    }
}
