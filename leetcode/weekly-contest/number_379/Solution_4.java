package number_379;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-379/problems/maximize-the-number-of-partitions-after-operations/">...</a>
 */
public class Solution_4 {
    public int maxPartitionsAfterOperations(String s, int k) {
        if (k == 26) return 1;
        char[] c = s.toCharArray();
        int n = s.length();
        int[] dpl = new int[n], dpr = new int[n + 1];
        int[] sizel = new int[n], sizer = new int[n];
        int[] maskL = new int[n], maskR = new int[n];
        boolean[] dupl = new boolean[n], dupr = new boolean[n];
        boolean[] t = new boolean[n];
        Set<Character> set = new HashSet<>();
        boolean x = false;
        for (int i = 0, cnt = 1, mask = 0; i < n; i++) {
            if (set.contains(c[i]) && set.size() == k) dupl[i] = true;
            if (set.size() == k && !set.contains(c[i])) {
                cnt++;
                set.clear();
                x = false;
                mask = 0;
            }
            if (set.contains(c[i])) x = true;
            set.add(c[i]);
            mask |= 1 << (c[i] - 'a');
            maskL[i] = mask;
            dpl[i] = cnt;
            sizel[i] = set.size();

            if (set.size() == k - 1 && i + 1 < n && !set.contains(c[i + 1])) {
                t[i] = x;
            }
        }
        set.clear();
        for (int i = n - 1, cnt = 1, mask = 0; i >= 0; i--) {
            if (set.contains(c[i]) && set.size() == k) dupr[i] = true;
            if (set.size() == k && !set.contains(c[i])) {
                cnt++;
                set.clear();
                mask = 0;
            }
            set.add(c[i]);
            mask |= 1 << (c[i] - 'a');
            maskR[i] = mask;
            dpr[i] = cnt;
            sizer[i] = set.size();
        }
        int re = dpl[n - 1];
        for (int i = 0; i < n; i++) {
            if (sizel[i] == k && dupl[i]) {
                int tmp = dpl[i] + dpr[i];
                if (dupr[i] && (maskL[i] | maskR[i]) != (1 << 26) - 1) tmp++;
                re = Math.max(re, tmp);
            }
            if (t[i]) re = Math.max(re, dpl[i] + dpr[i + 1]);
        }
        return re;
    }

}
