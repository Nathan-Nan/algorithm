package y_2023.m_12.d_04.zh;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/?envType=daily-question&envId=2023-12-04">...</a>
 */
public class Solution1038 {
    class TreeNode {
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

    /**
     * 中序遍历，AC
     */
    public TreeNode bstToGst(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        inOrder(root, stack);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (stack.peek() != null) {
                stack.peek().val += pop.val;
            }
        }
        return root;
    }

    private void inOrder(TreeNode root, Deque<TreeNode> stack) {
        if (root == null) return;
        inOrder(root.left, stack);
        stack.push(root);
        inOrder(root.right, stack);
    }

    /**
     * 中序遍历，优化空间复杂度
     */
    int preVal = 0;
    public TreeNode bstToGst1(TreeNode root) {
        if (root != null)
        {
            bstToGst1(root.right);
            preVal += root.val;
            root.val = preVal;
            bstToGst1(root.left);
        }
        return root;
    }
}
