package number_388.problem2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-388/problems/maximize-happiness-of-selected-children/">...</a>
 */
public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0L;
        for (int i = happiness.length - 1; i >= happiness.length - k; i--) {
            int happy = happiness[i] - (happiness.length - i - 1);
            if (happy >= 0) {
                sum += happy;
            }
        }
        return sum;
    }
}
