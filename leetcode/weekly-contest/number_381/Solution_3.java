package number_381;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-381/problems/minimum-number-of-pushes-to-type-word-ii/">...</a>
 */
public class Solution_3 {
    public int minimumPushes(String word) {
        int[] f = new int[128];
        for (char c : word.toCharArray()) {
            f[c]++;
        }
        // 贪心，把更大的频数优先分到8个按键上
        List<Integer> list = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (f[c] != 0) {
                list.add(f[c]);
            }
        }
        // 贪心，把更大的频数优先分到8个按键上
        list.sort((a, b) -> b - a);
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += (i / 8 + 1) * list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        System.out.println(solution.minimumPushes("abcde"));
    }
}
