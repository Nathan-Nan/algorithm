package y_2024.m04.d01.problem2810;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/faulty-keyboard/description/?envType=daily-question&envId=2024-04-01">...</a>
 */
public class Solution {
    public String finalString(String s) {
        Deque<Character> q = new ArrayDeque<>();
        boolean tail = true;
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                tail = !tail; // 修改添加方向
            } else if (tail) {
                q.addLast(c); // 加尾部
            } else {
                q.addFirst(c); // 加头部
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : q) {
            ans.append(c);
        }
        if (!tail) {
            ans.reverse();
        }
        return ans.toString();
    }
}
