package number398.p1;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-398/problems/special-array-i/">...</a>
 */
public class Solution {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int lastFlag = nums[0] & 1;
        for (int i = 1; i < nums.length; i++) {
            int curFlag = nums[i] & 1;
            if (curFlag == lastFlag) {
                return false;
            }
            lastFlag = curFlag;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isArraySpecial(new int[]{1}));
        System.out.println(solution.isArraySpecial(new int[]{2, 1, 4}));
        System.out.println(solution.isArraySpecial(new int[]{4, 3, 1, 6}));
    }
}
