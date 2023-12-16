package y_2023.m_12.d_16.zh;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/count-integers-in-intervals/description/?envType=daily-question&envId=2023-12-16">...</a>
 */
public class Solution2276 {

    /**
     * 超出内存限制
     */
    static class CountIntervals1 {

        private Set<Integer> set;

        public CountIntervals1() {
            set = new HashSet<>();
        }

        public void add(int left, int right) {
            for (int i = left; i < right + 1; i++) {
                set.add(i);
            }
        }

        public int count() {
            return set.size();

        }
    }

    /**
     * 珂朵莉树
     * AC
     */
    class CountIntervals2 {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        int cnt; // 所有区间长度和

        public CountIntervals2() {
        }

        public void add(int left, int right) {
            // 遍历所有被 [left,right] 覆盖到的区间（部分覆盖也算）
            for (Map.Entry<Integer, Integer> e = m.ceilingEntry(left); e != null && e.getValue() <= right; e = m.ceilingEntry(left)) {
                int l = e.getValue(), r = e.getKey();
                left = Math.min(left, l);   // 合并后的新区间，其左端点为所有被覆盖的区间的左端点的最小值
                right = Math.max(right, r); // 合并后的新区间，其右端点为所有被覆盖的区间的右端点的最大值
                cnt -= r - l + 1;
                m.remove(r);
            }
            cnt += right - left + 1;
            m.put(right, left); // 所有被覆盖到的区间与 [left,right] 合并成一个新区间
        }

        public int count() {
            return cnt;
        }
    }

    /**
     * 动态开点线段树
     * AC
     */
    static class CountIntervals {
        CountIntervals left, right;
        int l, r, cnt;

        public CountIntervals() {
            l = 1;
            r = (int) 1e9;
        }

        CountIntervals(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public void add(int L, int R) { // 为方便区分变量名，将递归中始终不变的入参改为大写（视作常量）
            if (cnt == r - l + 1) return; // 当前节点已被完整覆盖，无需执行任何操作
            if (L <= l && r <= R) { // 当前节点已被区间 [L,R] 完整覆盖，不再继续递归
                cnt = r - l + 1;
                return;
            }
            int mid = (l + r) / 2;
            if (left == null) left = new CountIntervals(l, mid); // 动态开点
            if (right == null) right = new CountIntervals(mid + 1, r); // 动态开点
            if (L <= mid) left.add(L, R);
            if (mid < R) right.add(L, R);
            cnt = left.cnt + right.cnt;
        }

        public int count() {
            return cnt;
        }
    }
}
