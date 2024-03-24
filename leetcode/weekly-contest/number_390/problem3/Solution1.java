package number_390.problem3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-390/problems/most-frequent-ids/">...</a>
 * <p>
 * 通过
 */
public class Solution1 {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        Map<Integer, Long> freqMap = new HashMap<>();
        PriorityQueue<long[]> queue = new PriorityQueue<>((o1, o2) -> (int) (o2[0] - o1[0]));
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            freqMap.merge(nums[i], (long) freq[i], Long::sum);
            queue.offer(new long[]{freqMap.get(nums[i]), nums[i]});
            while (!queue.isEmpty() && queue.peek()[0] != freqMap.get(((int) queue.peek()[1]))) {
                queue.poll();
            }
            ans[i] = queue.peek()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(Arrays.toString(solution.mostFrequentIDs(new int[]{2, 3, 2, 1}, new int[]{3, 2, -3, 1})));
        System.out.println(Arrays.toString(solution.mostFrequentIDs(new int[]{5, 5, 3}, new int[]{2, -2, 1})));
        System.out.println(Arrays.toString(solution.mostFrequentIDs(new int[]{2, 3, 2, 1}, new int[]{3, 2, -3, 1})));
    }
}
