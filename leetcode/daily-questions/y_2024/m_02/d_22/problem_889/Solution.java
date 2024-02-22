package y_2024.m_02.d_22.problem_889;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/?envType=daily-question&envId=2024-02-22">...</a>
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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        int[] index = new int[n + 1];
        for (int i = 0; i < n; i++) {
            index[postorder[i]] = i;
        }
        return dfs(preorder, 0, n, postorder, 0, n, index); // 左闭右开区间
    }

    private TreeNode dfs(int[] preorder, int preL, int preR, int[] postorder, int postL, int postR, int[] index) {
        if (preL == preR) { // 空节点
            return null;
        }
        if (preL + 1 == preR) { // 叶子节点
            return new TreeNode(preorder[preL]);
        }
        int leftSize = index[preorder[preL + 1]] - postL + 1; // 左子树的大小
        TreeNode left = dfs(preorder, preL + 1, preL + 1 + leftSize, postorder, postL, postL + leftSize, index);
        TreeNode right = dfs(preorder, preL + 1 + leftSize, preR, postorder, postL + leftSize, postR - 1, index);
        return new TreeNode(preorder[preL], left, right);
    }
}
