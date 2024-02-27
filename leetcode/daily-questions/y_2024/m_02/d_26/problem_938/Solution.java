package y_2024.m_02.d_26.problem_938;

/**
 * <a href="https://leetcode.cn/problems/range-sum-of-bst/description/?envType=daily-question&envId=2024-02-26">...</a>
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int x = root.val;
        if (x > high) { // 右子树没有节点在范围内，只需递归左子树
            return rangeSumBST(root.left, low, high);
        }
        if (x < low) { // 左子树没有节点在范围内，只需递归右子树
            return rangeSumBST(root.right, low, high);
        }
        return x + rangeSumBST(root.left, low, high) +
                rangeSumBST(root.right, low, high);
    }
}
