package y_2024.m03.d_31.problem331;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/description/?envType=daily-question&envId=2024-03-31">...</a>
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        LinkedList<String> stack = new LinkedList<>();
        for (String s : preorder.split(",")) {
            stack.push(s);
            while (stack.size() >= 3
                    && stack.get(0).equals("#")
                    && stack.get(1).equals("#")
                    && !stack.get(2).equals("#")) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }
}
