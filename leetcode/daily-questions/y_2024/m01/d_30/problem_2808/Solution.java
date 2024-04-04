package y_2024.m01.d_30.problem_2808;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/minimum-seconds-to-equalize-a-circular-array/description/?envType=daily-question&envId=2024-01-30">...</a>
 */
public class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }

        int ans = n;
        for (List<Integer> a : pos.values()) {
            int mx = n - a.get(a.size() - 1) + a.get(0);
            for (int i = 1; i < a.size(); i++) {
                mx = Math.max(mx, a.get(i) - a.get(i - 1));
            }
            ans = Math.min(ans, mx / 2); // 最后再除 2
        }
        return ans;
    }

}
