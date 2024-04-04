package y_2024.m04.d03.problem1379;

/**
 * <a href="https://leetcode.cn/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/?envType=daily-question&envId=2024-04-03">...</a>
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) {
            return cloned;
        }
        TreeNode leftRes = getTargetCopy(original.left, cloned.left, target);
        if (leftRes != null) {
            return leftRes; // 已经找到 target，无需递归右子树
        }
        return getTargetCopy(original.right, cloned.right, target);
    }
}
