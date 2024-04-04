package y_2024.m03.d_12.problem1261;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/description/?envType=daily-question&envId=2024-03-12">...</a>
 */
public class FindElements {
    private final Set<Integer> s = new HashSet<>();

    public FindElements(TreeNode root) {
        dfs(root, 0);
    }

    public boolean find(int target) {
        return s.contains(target);
    }

    private void dfs(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        s.add(val);
        dfs(node.left, val * 2 + 1);
        dfs(node.right, val * 2 + 2);
    }
}
