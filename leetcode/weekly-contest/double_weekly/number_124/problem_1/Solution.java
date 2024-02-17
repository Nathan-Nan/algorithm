package double_weekly.number_124.problem_1;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-124/problems/maximum-number-of-operations-with-the-same-score-i/">...</a>
 */
public class Solution {
    public int maxOperations(int[] nums) {
        int score = nums[0] + nums[1], ans = 1;
        for (int i = 2; i < nums.length - 1; ) {
            if (score == nums[i] + nums[i + 1]) {
                ans++;
                i += 2;
            } else {
                break;
            }
        }
        return ans;
    }
}
