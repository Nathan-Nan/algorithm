package zh;

/**
 * <a href="https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/description/?envType=daily-question&envId=2023-11-25">...</a>
 */
public class Solution1457 {

    public class TreeNode {
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

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] counts = new int[10];
        return dfs(root, counts);
    }

    private int dfs(TreeNode root, int[] counts) {
        if (root == null) return 0;
        if (root.left == root.right && isValid(counts)) {
            return 1;
        }
        counts[root.val] ^= 1;
        int res = dfs(root.right, counts) + dfs(root.left, counts);
        counts[root.val] ^= 1;
        return res;
    }

    private boolean isValid(int[] counts) {
        int cnt = 0;
        for (int count : counts) {
            cnt += count;
        }
        return cnt == 0 || cnt == 1;
    }

}
