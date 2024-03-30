package double_weekly.number127.problem2;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-127/problems/minimum-levels-to-gain-more-points/">...</a>
 */
public class Solution {
    public int minimumLevels(int[] possible) {
        int sum = 0;
        for (int i : possible) {
            sum += i == 0 ? -1 : 1;
        }
        int ans = 0;
        int score = 0;
        for (int i : possible) {
            score += i == 0 ? -1 : 1;
            ans++;
            if (score > sum - score) {
                break;
            }
        }
        return ans == possible.length ? -1 : ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumLevels(new int[]{0, 0, 0}));
    }
}
