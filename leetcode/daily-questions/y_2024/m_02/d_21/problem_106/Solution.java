package y_2024.m_02.d_21.problem_106;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=daily-question&envId=2024-02-21">...</a>
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> index = new HashMap<>(n); // 预分配空间
        for (int i = 0; i < n; i++) {
            index.put(inorder[i], i);
        }
        return dfs(inorder, 0, n, postorder, 0, n, index); // 左闭右开区间
    }

    private TreeNode dfs(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR, Map<Integer, Integer> index) {
        if (postL == postR) { // 空节点
            return null;
        }
        int leftSize = index.get(postorder[postR - 1]) - inL; // 左子树的大小
        TreeNode left = dfs(inorder, inL, inL + leftSize, postorder, postL, postL + leftSize, index);
        TreeNode right = dfs(inorder, inL + leftSize + 1, inR, postorder, postL + leftSize, postR - 1, index);
        return new TreeNode(postorder[postR - 1], left, right);
    }


}
