package double_weekly.number122;

import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-122/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/">...</a>
 */
public class Solution_4 {
    public long minimumCost(int[] nums, int k, int dist) {
        int[] b = nums;
        int n = b.length;
        CntMap a = new CntMap();
        CntMap c = new CntMap();
        long ret = 0;
        for (int i = 0; i < k; ++i) ret += b[i];
        for (int i = 1; i < n && i <= 1 + dist; ++i) a.add(b[i]);
        while (a.size() > k - 1) {
            int x = a.cm.lastKey();
            a.remove(x);
            c.add(x);
        }
        long r = b[0];
        for (int x : a.cm.keySet()) r += x * (long) a.cm.get(x);
        ret = Math.min(ret, r);
        for (int i = 2; i < n; ++i) {
            if (n - i < k - 1) break;
            int x = b[i - 1];
            if (c.cm.containsKey(x)) {
                c.remove(x);
            } else {
                a.remove(x);
                r -= x;
            }
            if (i + dist < n) {
                x = b[i + dist];
                c.add(x);
            }
            if (a.size() < k - 1) {
                x = c.cm.firstKey();
                c.remove(x);
                a.add(x);
                r += x;
            } else {
                if (!c.cm.isEmpty() && !a.cm.isEmpty()
                        && c.cm.firstKey() < a.cm.lastKey()) {
                    x = c.cm.firstKey();
                    int y = a.cm.lastKey();
                    a.remove(y);
                    c.add(y);
                    c.remove(x);
                    a.add(x);
                    r -= y;
                    r += x;
                }
            }
            ret = Math.min(ret, r);
        }
        return ret;
    }

    static class CntMap {
        TreeMap<Integer, Integer> cm = new TreeMap<>();
        int tot = 0;

        void clear() {
            cm.clear();
            tot = 0;
        }

        boolean add(int x) {
            return add(x, 1);
        }

        boolean add(int x, int v) {
            if (v <= 0) throw new RuntimeException("v should be positive.");
            tot += v;
            if (!cm.containsKey(x)) {
                cm.put(x, v);
                return true; // original absent key.
            }
            cm.put(x, cm.get(x) + v);
            return false;
        }

        boolean remove(int x) {
            if (!cm.containsKey(x)) return false;
            tot--;
            if (cm.get(x) == 1) {
                cm.remove(x);
                return true; // key removed.
            }
            cm.put(x, cm.get(x) - 1);
            return false;
        }

        int get(int x) {
            return cm.getOrDefault(x, 0);
        }

        int size() {
            return tot;
        }

        boolean isEmpty() {
            return tot == 0;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (!cm.isEmpty())
                for (int k : cm.keySet()) sb.append(k + ":" + cm.get(k) + " ");
            sb.append("]");
            return sb.toString();
        }
    }

}
