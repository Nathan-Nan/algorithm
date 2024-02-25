package number_386.problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-386/problems/earliest-second-to-mark-indices-i/">...</a>
 */
public class Solution {

    boolean pd(int[] nums, int[] ch, int tgt) {
        int n = nums.length;
        int[] pos = new int[n];
        for (int i = 0; i < tgt; i++) {
            pos[ch[i] - 1] = i + 1;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (pos[i] == 0) {
                return false;
            }
            if (!map.containsKey(pos[i])) {
                map.put(pos[i], new ArrayList<>());
            }
            map.get(pos[i]).add(i);
        }
        int s = 0;
        for (int i = 1; i <= tgt; i++) {
            if (map.containsKey(i)) {
                for (int k : map.get(i)) {
                    s++;
                    s += nums[k];
                }
            }
            if (s > i) {
                return false;
            }
        }
        return true;

    }

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int m = changeIndices.length;
        int x = 1;
        int y = m;
        while (x < y) {
            int mid = (x + y) / 2;
            if (pd(nums, changeIndices, mid)) {
                y = mid;
            } else {
                x = mid + 1;
            }
        }
        while (y <= m && !pd(nums, changeIndices, y)) {
            y++;
        }
        return y <= m ? y : -1;
    }
}
