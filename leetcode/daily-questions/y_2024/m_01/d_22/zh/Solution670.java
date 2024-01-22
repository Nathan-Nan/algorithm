package y_2024.m_01.d_22.zh;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-swap/?envType=daily-question&envId=2024-01-22">...</a>
 */
public class Solution670 {
    /**
     * 暴力枚举每一个结果，求最大的，O(n ^ 2)
     * AC
     */
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        if (s.length() == 1) return num;
        int max = num;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] >= chars[j]) continue;
                char[] c = Arrays.copyOf(chars, chars.length);
                c[j] = chars[i];
                c[i] = chars[j];
                max = Math.max(max, Integer.parseInt(String.valueOf(c)));
            }
        }

        return max;
    }

    /**
     * 交换的是从左到右第一个右边有比它大的数字，O(log nums)
     * AC
     * 参考题解：<a href="https://leetcode.cn/problems/maximum-swap/solutions/2614470/yi-ci-bian-li-jian-ji-xie-fa-pythonjavac-c9b1/?envType=daily-question&envId=2024-01-22">...</a>
     */
    public int maximumSwap1(int num) {
        char[] s = Integer.toString(num).toCharArray();
        int maxIdx = s.length - 1;
        int p = -1, q = 0;
        for (int i = s.length - 2; i >= 0; i--) {
            if (s[i] > s[maxIdx]) { // s[i] 是目前最大数字
                maxIdx = i;
            } else if (s[i] < s[maxIdx]) { // s[i] 右边有比它大的
                p = i;
                q = maxIdx; // 更新 p 和 q
            }
        }
        if (p == -1) { // 这意味着 s 是降序的
            return num;
        }
        char temp = s[p];
        s[p] = s[q];
        s[q] = temp; // 交换 s[p] 和 s[q]
        return Integer.parseInt(new String(s));
    }

    public static void main(String[] args) {
        Solution670 solution = new Solution670();
        System.out.println(solution.maximumSwap(2736));
        System.out.println(solution.maximumSwap(9973));
    }
}
