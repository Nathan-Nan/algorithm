package y_2023.m_11.d_24.zh;

import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/description/?envType=daily-question&envId=2023-11-24">...</a>
 * <p>
 * Easy
 */
public class Solution2824 {
    /**
     * 暴力解法，时间复杂度 O(n^2)
     */
    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) ans++;
            }
        }
        return ans;
    }


    /**
     * 排序 + 双指针
     * <p>
     * 时间复杂度：O(n log n)
     */
    public int countPairs1(List<Integer> nums, int target) {
        int ans = 0, n = nums.size();
        nums.sort(Integer::compareTo);
        Collections.sort(nums);
        for (int l = 0, r = n - 1; l < r; l++) {
            while (r >= 0 && nums.get(l) + nums.get(r) >= target) r--;
            if (l < r) ans += r - l;
        }
        return ans;
    }
}
