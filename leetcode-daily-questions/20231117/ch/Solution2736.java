package ch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-sum-queries/description/">...</a>
 */
public class Solution2736 {
    /**
     * 暴力解法，超时
     */
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int sum = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (nums1[j] >= x && nums2[j] >= y) {
                    sum = Math.max(sum, nums1[j] + nums2[j]);
                }
            }
            result[i] = sum == Integer.MIN_VALUE ? -1 : sum;
        }
        return result;
    }

    /**
     * 单调栈解法，ac
     */
    public int[] maximumSumQueries2(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nums1[i];
            a[i][1] = nums2[i];
        }
        Arrays.sort(a, (x, y) -> y[0] - x[0]);

        Integer[] qid = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qid[i] = i;
        }
        Arrays.sort(qid, (i, j) -> queries[j][0] - queries[i][0]);

        int[] ans = new int[queries.length];
        List<int[]> st = new ArrayList<>();
        int j = 0;
        for (int i : qid) {
            int x = queries[i][0], y = queries[i][1];
            for (; j < n && a[j][0] >= x; j++) { // 下面只需关心 a[j][1]
                while (!st.isEmpty() && st.get(st.size() - 1)[1] <= a[j][0] + a[j][1]) { // a[j][1] >= st.get(st.size()-1)[0]
                    st.remove(st.size() - 1);
                }
                if (st.isEmpty() || st.get(st.size() - 1)[0] < a[j][1]) {
                    st.add(new int[]{a[j][1], a[j][0] + a[j][1]});
                }
            }
            int p = lowerBound(st, y);
            ans[i] = p < st.size() ? st.get(p)[1] : -1;
        }
        return ans;
    }

    // 二分查找
    private int lowerBound(List<int[]> st, int target) {
        int left = -1, right = st.size(); // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            int mid = (left + right) >>> 1;
            if (st.get(mid)[0] >= target) {
                right = mid; // 范围缩小到 (left, mid)
            } else {
                left = mid; // 范围缩小到 (mid, right)
            }
        }
        return right;
    }

    class Node {
        int x, y, id, flag;

        public Node(int x, int y, int id, int flag) {
            this.x = x;
            this.y = y;
            this.id = id;
            this.flag = flag;
        }
    }

    class Tree {
        int l, r, m, v;
        Tree left, right;

        public Tree(int l, int r, int v) {
            this.l = l;
            this.r = r;
            this.v = v;
            m = (l + r) >> 1;
        }

        private Tree getLeft() {
            return left == null ? (left = new Tree(l, m, v)) : left;
        }

        private Tree getRight() {
            return right == null ? (right = new Tree(m + 1, r, v)) : right;
        }

        public void update(int low, int high, int val) {
            if (high < l || low > r) return;
            if (l >= low && r <= high) {
                v = Math.max(v, val);
                return;
            }
            getLeft().update(low, high, val);
            getRight().update(low, high, val);
            v = Math.max(v, Math.max(left.v, right.v));
        }

        public int query(int low, int high) {
            if (high < l || low > r || v == -1) return -1;
            if (l >= low && r <= high) return v;
            return Math.max(getLeft().query(low, high), getRight().query(low, high));
        }
    }

    /**
     * 动态开点线段树，ac
     */
    public int[] maximumSumQueries3(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length, m = queries.length;
        Node[] nodes = new Node[n + m];
        for (int i = 0; i < n; ++i) nodes[i] = new Node(nums1[i], nums2[i], i, 0);
        for (int i = 0; i < m; ++i) nodes[i + n] = new Node(queries[i][0], queries[i][1], i, 1);
        Arrays.sort(nodes, (a, b) -> a.x == b.x ? Integer.compare(a.flag, b.flag) : Integer.compare(b.x, a.x));
        int end = (int) 1e9;
        Tree root = new Tree(0, end, -1);
        int[] ans = new int[m];
        for (Node node : nodes) {
            if (node.flag == 0) root.update(node.y, node.y, node.x + node.y);
            else ans[node.id] = root.query(node.y, end);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution2736 solution = new Solution2736();
        System.out.println(Arrays.toString(solution.maximumSumQueries(new int[]{4, 3, 1, 2}, new int[]{2, 4, 9, 5}, new int[][]{{4, 1}, {1, 3}, {2, 5}})));
    }
}
