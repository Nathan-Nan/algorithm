package y_2024.m02.d_08.problem_993;

/**
 * <a href="https://leetcode.cn/problems/cousins-in-binary-tree/description/?envType=daily-question&envId=2024-02-08">...</a>
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

    private int depth;
    private TreeNode father;

    public boolean isCousins(TreeNode root, int x, int y) {
        return dfs(root, null, 1, x, y);
    }

    private boolean dfs(TreeNode node, TreeNode fa, int d, int x, int y) {
        if (node == null) {
            return false;
        }
        if (node.val == x || node.val == y) { // 找到 x 或 y
            if (depth > 0) { // 之前已找到 x y 其中一个
                return depth == d && father != fa;
            }
            depth = d; // 之前没找到，记录信息
            father = fa;
        }
        return dfs(node.left, node, d + 1, x, y) || dfs(node.right, node, d + 1, x, y);
    }

}
