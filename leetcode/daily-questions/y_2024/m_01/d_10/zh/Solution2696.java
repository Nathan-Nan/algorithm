package y_2024.m_01.d_10.zh;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/minimum-string-length-after-removing-substrings/description/?envType=daily-question&envId=2024-01-10">...</a>
 */
public class Solution2696 {
    /**
     * JDK API 实现
     */
    public int minLength(String s) {
        while (s.length() > 2) {
            int length = s.length();
            s = s.replace("AB", "");
            s = s.replace("CD", "");
            if (s.length() == length) {
                break;
            }
        }
        return s.length();
    }

    /**
     * 借助辅助栈
     */
    public int minLength1(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == 'A' && c == 'B') {
                stack.pop();
            } else if (stack.peek() == 'C' && c == 'D') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Solution2696 solution = new Solution2696();
        System.out.println(solution.minLength1("ABFCACDB"));
        System.out.println(solution.minLength1("ACBBD"));
    }
}
