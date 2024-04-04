package y_2024.m01.d_06.en;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/?envType=daily-question&envId=2024-01-06">...</a>
 */
public class Solution1235 {

    /**
     * DP + 二分查找
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[1]));
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int j = search(jobs, i, jobs[i][0]);
            f[i + 1] = Math.max(f[i], f[j + 1] + jobs[i][2]);
        }
        return f[n];
    }

    private int search(int[][] jobs, int right, int upper) {
        int left = -1;
        while (left + 1 < right) {
            int mid = left + ((right - left) >> 1);
            if (jobs[mid][1] <= upper) left = mid;
            else right = mid;
        }
        return left;
    }
}