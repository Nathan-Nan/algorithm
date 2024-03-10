package number_388.problem1;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-388/problems/apple-redistribution-into-boxes/">...</a>
 */
public class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = Arrays.stream(apple).sum();
        Arrays.sort(capacity);
        int ans = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (sum <= 0) {
                break;
            }
            sum -= capacity[i];
            ans++;
        }
        return ans;
    }
}
