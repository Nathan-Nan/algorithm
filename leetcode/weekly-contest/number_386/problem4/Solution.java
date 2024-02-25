package number_386.problem4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-386/problems/earliest-second-to-mark-indices-ii/">...</a>
 */
public class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        long sum = 0;
        int n = nums.length;
        int m = changeIndices.length;
        for (int v : nums) sum += v;
        int[] first = new int[n + 1];
        int[] fp = new int[m];
        Arrays.fill(first, -1);
        Arrays.fill(fp, -1);
        for (int i = 0; i < m; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> nums[o]));
            long ts = sum;
            if (first[changeIndices[i]] == -1) {
                first[changeIndices[i]] = i;
                fp[i] = changeIndices[i] - 1;
            }
            int cnt = 0;
            for (int j = i; j >= 0; j--) {
                if (fp[j] == -1 || nums[fp[j]] <= 1) continue;
                cnt++;
                ts -= nums[fp[j]];
                pq.add(fp[j]);
                if (pq.size() * 2 > (i - j + 1)) {
                    int t = pq.poll();
                    cnt--;
                    ts += nums[t];
                }
            }
            if (i + 1 - cnt * 2 >= ts + n - cnt) return i + 1;
        }
        return -1;
    }
}
