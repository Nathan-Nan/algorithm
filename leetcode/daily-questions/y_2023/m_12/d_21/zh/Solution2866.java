package y_2023.m_12.d_21.zh;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/beautiful-towers-ii/description/?envType=daily-question&envId=2023-12-21">...</a>
 */
public class Solution2866 {

    /**
     * 暴力解法
     * 找到所有的山脉数组求取最大值
     * 超时
     */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < maxHeights.size(); i++) {
            map.computeIfAbsent(maxHeights.get(i), v -> new ArrayList<>()).add(i);
        }
        return map.entrySet().stream().map(e -> e.getValue().stream().map(id -> maximumSumOfHeights(maxHeights, id)).max(Long::compareTo).get()).max(Long::compare).get();
    }

    private long maximumSumOfHeights(List<Integer> maxHeights, int idxOfMax) {
        // 定义山脉数组
        int[] heights = new int[maxHeights.size()];
        heights[idxOfMax] = maxHeights.get(idxOfMax);
        // 处理峰值左边
        for (int i = idxOfMax - 1; i >= 0; i--) {
            if (maxHeights.get(i) <= heights[i + 1]) {
                heights[i] = maxHeights.get(i);
            } else {
                heights[i] = heights[i + 1];
            }
        }
        // 处理峰值右边
        for (int i = idxOfMax + 1; i < maxHeights.size(); i++) {
            if (maxHeights.get(i) <= heights[i - 1]) {
                heights[i] = maxHeights.get(i);
            } else {
                heights[i] = heights[i - 1];
            }
        }
        return Arrays.stream(heights).mapToLong(i -> (long) i).sum();
    }

    /**
     * 前缀和数组 + 单调栈
     * 前缀和为峰顶左侧和
     * 后缀和为峰顶右侧和
     * AC
     */
    public long maximumSumOfHeights1(List<Integer> maxHeights) {
        int[] a = maxHeights.stream().mapToInt(i -> i).toArray();
        int n = a.length;
        long[] suf = new long[n + 1];
        Deque<Integer> st = new ArrayDeque<>();
        st.push(n); // 哨兵
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int x = a[i];
            while (st.size() > 1 && x <= a[st.peek()]) {
                int j = st.pop();
                sum -= (long) a[j] * (st.peek() - j); // 撤销之前加到 sum 中的
            }
            sum += (long) x * (st.peek() - i); // 从 i 到 st.peek()-1 都是 x
            suf[i] = sum;
            st.push(i);
        }

        long ans = sum;
        st.clear();
        st.push(-1); // 哨兵
        long pre = 0;
        for (int i = 0; i < n; i++) {
            int x = a[i];
            while (st.size() > 1 && x <= a[st.peek()]) {
                int j = st.pop();
                pre -= (long) a[j] * (j - st.peek()); // 撤销之前加到 pre 中的
            }
            pre += (long) x * (i - st.peek()); // 从 st.peek()+1 到 i 都是 x
            ans = Math.max(ans, pre + suf[i + 1]);
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2866 solution = new Solution2866();
        System.out.println(solution.maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1)));
        System.out.println(solution.maximumSumOfHeights(Arrays.asList(6, 5, 3, 9, 2, 7)));
        System.out.println(solution.maximumSumOfHeights(Arrays.asList(3, 2, 5, 5, 2, 3)));
        System.out.println(solution.maximumSumOfHeights(Arrays.asList(1000000000, 1000000000, 1000000000)));
        System.out.println(solution.maximumSumOfHeights(Arrays.asList(3, 5, 3, 5, 1, 5, 4, 4, 4)));
        System.out.println(solution.maximumSumOfHeights(Arrays.asList(5, 5, 2, 1, 5, 4, 4, 2)));
    }
}
