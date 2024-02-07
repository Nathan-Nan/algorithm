package y_2024.m_02.d_07.problem_2641;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/cousins-in-binary-tree-ii/description/?envType=daily-question&envId=2024-02-07">...</a>
 */
public class Solution {
    static class TreeNode {
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
     * BFS
     */
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int sum = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int nextSum = 0;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                node.val = sum - node.val;
                if (node.left != null && node.right != null) {
                    nextSum += node.left.val + node.right.val;
                    node.left.val += node.right.val;
                    node.right.val = node.left.val;
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else if (node.right != null) {
                    nextSum += node.right.val;
                    queue.offer(node.right);
                } else if (node.left != null) {
                    nextSum += node.left.val;
                    queue.offer(node.left);
                }
            }
            sum = nextSum;
        }
        return root;
    }
}
