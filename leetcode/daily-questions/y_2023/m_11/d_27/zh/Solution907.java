package y_2023.m_11.d_27.zh;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/sum-of-subarray-minimums/solutions/1930857/gong-xian-fa-dan-diao-zhan-san-chong-shi-gxa5/?envType=daily-question&envId=2023-11-27">...</a>
 */
public class Solution907 {
    /**
     * 暴力解法，超时
     */
    public int sumSubarrayMins(int[] arr) {
        int ans = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length + 1; j++) {
                int min = arr[i];
                for (int k = i; k < j; k++) {
                    min = Math.min(min, arr[k]);
                }
                ans = (ans + min) % mod;
            }
        }
        return ans;
    }


    /**
     * 贡献法+单调栈，计算每个元素是几个子数组的最小值
     * <p>
     * 利用 left、right 数组计算左右边界
     * left[i]：arr[i] 左边最近的严格小于它的元素下标
     * right[i]：arr[i] 右边最近的小于等于它的元素下标
     * <p>
     * 利用三次循环实现
     */
    public int sumSubarrayMins1(int[] arr) {
        int n = arr.length;
        final long MOD = (long) 1e9 + 7;
        // 左边界 left[i] 为左侧严格小于 arr[i] 的最近元素位置（不存在时为 -1）
        int[] left = new int[n];
        Deque<Integer> st = new ArrayDeque<>(); // 注：推荐用 ArrayDeque 实现栈
        st.push(-1); // 方便赋值 left
        for (int i = 0; i < n; ++i) {
            while (st.size() > 1 && arr[st.peek()] >= arr[i])
                st.pop(); // 移除无用数据
            left[i] = st.peek();
            st.push(i);
        }

        // 右边界 right[i] 为右侧小于等于 arr[i] 的最近元素位置（不存在时为 n）
        int[] right = new int[n];
        st.clear();
        st.push(n); // 方便赋值 right
        for (int i = n - 1; i >= 0; --i) {
            while (st.size() > 1 && arr[st.peek()] > arr[i])
                st.pop(); // 移除无用数据
            right[i] = st.peek();
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; ++i)
            ans += (long) arr[i] * (i - left[i]) * (right[i] - i); // 累加贡献
        return (int) (ans % MOD);
    }

    /**
     * 贡献法+单调栈，两次循环实现，将计算 left、right 数组的循环合并
     */
    public int sumSubarrayMins2(int[] arr) {
        int n = arr.length;
        final long MOD = (long) 1e9 + 7;
        // 左边界 left[i] 为左侧严格小于 arr[i] 的最近元素位置（不存在时为 -1）
        int[] left = new int[n];
        // 右边界 right[i] 为右侧小于等于 arr[i] 的最近元素位置（不存在时为 n）
        int[] right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> st = new ArrayDeque<>(); // 注：推荐用 ArrayDeque 实现栈
        st.push(-1); // 方便赋值 left
        for (int i = 0; i < n; ++i) {
            while (st.size() > 1 && arr[st.peek()] >= arr[i])
                right[st.pop()] = i;
            left[i] = st.peek();
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; ++i)
            ans += (long) arr[i] * (i - left[i]) * (right[i] - i); // 累加贡献
        return (int) (ans % MOD);
    }

    /**
     * 贡献法+单调栈，一次循环实现
     * <p>
     * 由于栈顶下面的元素正好也是栈顶的左边界，所以甚至连 left 和 right 数组都可以不要，直接在出栈的时候计算贡献。
     * <p>
     * 为简化代码逻辑，可以在遍历前，往 arr 末尾和栈顶分别加一个 −1 当作哨兵。
     */
    public int sumSubarrayMins3(int[] arr) {
        long ans = 0;
        final long MOD = (long) 1e9 + 7;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1); // 哨兵
        for (int r = 0; r <= arr.length; ++r) {
            int x = r < arr.length ? arr[r] : -1; // 假设 arr 末尾有个 -1
            while (st.size() > 1 && arr[st.peek()] >= x) {
                int i = st.pop();
                ans += (long) arr[i] * (i - st.peek()) * (r - i); // 累加贡献
            }
            st.push(r);
        }
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        Solution907 solution = new Solution907();
        System.out.println(solution.sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println(solution.sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));
    }
}
