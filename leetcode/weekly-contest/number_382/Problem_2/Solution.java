package number_382.Problem_2;

import java.util.*;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-382/problems/find-the-maximum-number-of-elements-in-subset/">...</a>
 */
public class Solution {
    public int maximumLength(int[] nums) {
        int ans = 1;
        Map<Integer, Integer> f = new HashMap<>();
        for (int num : nums) {
            f.merge(num, 1, Integer::sum);
        }
        Arrays.sort(nums);
        if (nums[0] == 1 && f.get(1) > 1) {
            Integer cnt = f.get(1);
            ans = cnt % 2 == 0 ? cnt - 1 : cnt;
        }
        for (int num : nums) {
            if (num == 1) {
                continue;
            }
            int n = num;
            List<Integer> sub = new ArrayList<>();
            sub.add(n);
            while (f.get(n) > 1) {
                int powed = (int) Math.pow(n, 2);
                if (!f.containsKey(powed)) {
                    break;
                }
                sub.add(n);
                sub.add(powed);
                n = powed;
            }
            ans = Math.max(ans, sub.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumLength(new int[]{1, 1}));
        System.out.println(solution.maximumLength(new int[]{5, 4, 1, 2, 2}));
        System.out.println(solution.maximumLength(new int[]{1, 3, 2, 4}));
        System.out.println(solution.maximumLength(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024}));
    }
}
