package y_2023.m_12.d_08.en;

/**
 * <a href="https://leetcode.cn/problems/construct-string-from-binary-tree/description/">...</a>
 */
public class Solution606 {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public String tree2str(TreeNode root) {
        if (root == null) return "";
        StringBuilder ans = new StringBuilder();
        ans.append(root.val);
        if (root.left != null) {
            ans.append('(')
                    .append(tree2str(root.left))
                    .append(')');
        } else if (root.right != null) {
            ans.append("()");
        }
        if (root.right != null) {
            ans.append("(")
                    .append(tree2str(root.right))
                    .append(")");
        }
        return ans.toString();
    }

}
