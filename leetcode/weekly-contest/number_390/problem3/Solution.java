package number_390.problem3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-390/problems/most-frequent-ids/">...</a>
 * <p>
 * 超时
 */
public class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        Map<Integer, Long> freqMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Long>> queue = new PriorityQueue<>(Map.Entry.comparingByValue());
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            queue.clear();
            long cnt = freqMap.getOrDefault(nums[i], 0L);
            if (cnt + freq[i] > 0) {
                freqMap.put(nums[i], cnt + freq[i]);
            } else {
                freqMap.remove(nums[i]);
            }
            for (Map.Entry<Integer, Long> entry : freqMap.entrySet()) {
                queue.offer(entry);
            }
            if (queue.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = queue.peek().getValue();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.mostFrequentIDs(new int[]{2, 3, 2, 1}, new int[]{3, 2, -3, 1})));
        System.out.println(Arrays.toString(solution.mostFrequentIDs(new int[]{5, 5, 3}, new int[]{2, -2, 1})));
        System.out.println(Arrays.toString(solution.mostFrequentIDs(new int[]{2, 3, 2, 1}, new int[]{3, 2, -3, 1})));
    }
}
