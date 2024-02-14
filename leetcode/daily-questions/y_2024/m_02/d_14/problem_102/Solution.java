package y_2024.m_02.d_14.problem_102;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=daily-question&envId=2024-02-14">...</a>
 */
public class Solution {

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

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderHelp(root, 0);
        return res;
    }

    private void levelOrderHelp(TreeNode root, int level) {
        if (root == null) return;
        if (res.size() == level) res.add(new ArrayList<Integer>());
        res.get(level).add(root.val);
        levelOrderHelp(root.left, level + 1);
        levelOrderHelp(root.right, level + 1);
    }


}
