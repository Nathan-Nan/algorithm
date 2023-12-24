package number_377;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-377/problems/maximum-square-area-by-removing-fences-from-a-field/">...</a>
 */
public class Solution_2 {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long mod = (long) (1e9 + 7);
        if (m == n) return (int) ((m - 1) * (n - 1) % mod);
        Set<Integer> hs = new HashSet<>();
        hs.add(n - 1);
        for (int v : vFences) {
            hs.add(v - 1);
            hs.add(n - v);
            for (int v1 : vFences) {
                hs.add(Math.abs(v1 - v));
            }
        }
        int max = 0;
        for (int h : hFences) {
            if (hs.contains(h - 1)) {
                max = Math.max(max, h - 1);
            }
            if (hs.contains(m - h)) {
                max = Math.max(max, m - h);
            }
            for (int h1 : hFences) {
                int t = Math.abs(h - h1);
                if (hs.contains(t)) {
                    max = Math.max(max, t);
                }
            }
        }
        if (hs.contains(m - 1)) {
            max = Math.max(max, m - 1);
        }
        if (max == 0)
            return -1;
        return (int) ((long) max * max % mod);
    }
}
