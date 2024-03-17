package number_389.problem4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-389/problems/minimum-moves-to-pick-k-ones/">...</a>
 */
public class Solution {
    public long minimumMoves(int[] nums, int k, int maxChanges) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                maxLen = 1;
                break;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 1 && nums[i + 1] == 1) {
                maxLen = 2;
                break;
            }
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 1 && nums[i + 1] == 1 && nums[i + 2] == 1) {
                maxLen = 3;
                break;
            }
        }
        if (maxLen + maxChanges >= k) {
            int[] dict = new int[]{0, 1, 2};
            if (maxLen >= k) {
                return dict[k - 1];
            } else {
                return (maxLen == 0 ? 0 : dict[maxLen - 1]) + (k - maxLen) * 2;
            }

        }
        int index = 0;
        List<Integer> onePos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                onePos.add(i);
            }
        }
        // long base=maxChanges*2;
        int need = k - maxChanges;
        long leftCost = 0;
        long rightCost = 0;
        ArrayDeque<Integer> lDeque = new ArrayDeque<>();
        ArrayDeque<Integer> rDeque = new ArrayDeque<>();
        while (rDeque.size() < need) {
            rightCost += onePos.get(index);
            rDeque.addLast(onePos.get(index));
            index++;
        }
        long res = rightCost;
        for (int i = 1; i < nums.length; i++) {
            if (!rDeque.isEmpty() && rDeque.peekFirst() == i - 1) {
                rightCost -= rDeque.peekFirst();
                leftCost += rDeque.peekFirst();
                lDeque.addLast(rDeque.pollFirst());
            }
            if (!lDeque.isEmpty() && index < onePos.size() && i - lDeque.peekFirst() > onePos.get(index) - i) {
                // 移动
                leftCost -= lDeque.removeFirst();
                rightCost += onePos.get(index);
                rDeque.addLast(onePos.get(index));
                index++;
            }
            res = Math.min(res, (long) i * lDeque.size() - leftCost + rightCost - (long) i * rDeque.size());
        }
        return res + maxChanges * 2L;
    }
}
