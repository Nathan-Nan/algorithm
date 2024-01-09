package y_2024.m_01.d_09.en;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/leaf-similar-trees/description/?envType=daily-question&envId=2024-01-09">...</a>
 */
public class Solution872 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void dfs(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        dfs(root.left, leaves);
        dfs(root.right, leaves);
    }
}
