package y_2024.m01.d_27.problem_2861;

import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-alloys/description/?envType=daily-question&envId=2024-01-27">...</a>
 */
public class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int ans = 0, max = Collections.min(stock) + budget;
        for (List<Integer> comps : composition) {
            int left = ans, right = max;
            while (left < right) {
                int mid = left + (right - left) / 2;
                boolean isAnswer = true;
                long money = 0;
                for (int i = 0; i < n; i++) {
                    if (stock.get(i) < (long) comps.get(i) * mid) {
                        money += ((long) comps.get(i) * mid - stock.get(i)) * cost.get(i);
                        if (money > budget) {
                            isAnswer = false;
                            break;
                        }
                    }
                }
                if (isAnswer) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            ans = left;
        }
        return ans;
    }
}
