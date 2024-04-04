package y_2024.m01.d_02.en;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/?envType=daily-question&envId=2024-01-02">...</a>
 */
public class Solution2610 {

    /**
     * 解法一
     */
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int num : nums) {
            Set<Integer> rows = map.getOrDefault(num, new HashSet<>());
            if (rows.size() == res.size()) {
                List<Integer> cur = new ArrayList<>();
                cur.add(num);
                res.add(cur);
                rows.add(res.size() - 1);
                map.put(num, rows);
            }
            for (int i = 0; i < res.size(); i++) {
                if (!rows.contains(i)) {
                    res.get(i).add(num);
                    rows.add(i);
                    map.put(num, rows);
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 解法二
     */
    public List<List<Integer>> findMatrix1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int[] counts = new int[n + 1];
        for (int num : nums) {
            counts[num] += 1;
        }
        for (int i = 1; i < counts.length; i++) {
            int count = counts[i];
            if (count == 0) {
                continue;
            }
            for (int j = res.size(); j < count; j++) {
                res.add(new ArrayList<>());
            }
            for (int j = 0; j < count; j++) {
                res.get(j).add(i);
            }
        }
        return res;
    }

    /**
     * 解法三
     */
    public List<List<Integer>> findMatrix2(int[] nums) {
        int[] freq = new int[nums.length + 1];

        List<List<Integer>> ans = new ArrayList<>();
        for (int c : nums) {
            if (freq[c] >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            ans.get(freq[c]).add(c);
            freq[c]++;
        }

        return ans;
    }
}
