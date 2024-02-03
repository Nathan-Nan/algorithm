package double_weekly.number_123;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-123/problems/maximum-good-subarray-sum/">...</a>
 */
public class Solution3 {

    /**
     * 超时
     */
    public long maximumSubarraySum(int[] nums, int k) {
        long[] sum = new long[nums.length + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
            map.computeIfAbsent(nums[i], v -> new ArrayList<>()).add(i);
        }
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> idx = new ArrayList<>();
            idx.addAll(map.getOrDefault(nums[i] + k, new ArrayList<>()));
            idx.addAll(map.getOrDefault(nums[i] - k, new ArrayList<>()));
            for (Integer j : idx) {

                int max = Math.max(i, j), min = Math.min(i, j);
                ans = Math.max(ans, sum[max + 1] - sum[min]);
            }
        }
        return ans == Long.MIN_VALUE ? 0 : ans;
    }


    /**
     * AC
     */
    public long maximumSubarraySum1(int[] nums, int k) {
        long sum = 0, res = Long.MIN_VALUE;
        HashMap<Integer, Long> mem = new HashMap<>();
        for (int num : nums) {
            long curSum = sum + num;
            if (mem.containsKey(num + k)) {
                res = Math.max(res, curSum - mem.get(num + k));
            }
            if (mem.containsKey(num - k)) {
                res = Math.max(res, curSum - mem.get(num - k));
            }
            if (!mem.containsKey(num) || mem.get(num) > sum) {
                mem.put(num, sum);
            }
            sum = curSum;
        }
        return res == Long.MIN_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        // System.out.println(solution.maximumSubarraySum(new int[]{1, 2, 3, 4, 5, 6}, 1));
        // System.out.println(solution.maximumSubarraySum(new int[]{-1, 3, 2, 4, 5}, 3));
        System.out.println(solution.maximumSubarraySum(new int[]{-1, -2, -3, -4}, 2));
        // System.out.println(solution.maximumSubarraySum(new int[]{1, 5}, 2));
    }
}
