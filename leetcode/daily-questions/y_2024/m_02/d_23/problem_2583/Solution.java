package y_2024.m_02.d_23.problem_2583;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/kth-largest-sum-in-a-binary-tree/description/?envType=daily-question&envId=2024-02-23">...</a>
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

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> a = new ArrayList<>();
        List<TreeNode> q = new ArrayList<TreeNode>() {{
            add(root);
        }};
        while (!q.isEmpty()) {
            long sum = 0;
            List<TreeNode> tmp = q;
            q = new ArrayList<>();
            for (TreeNode node : tmp) {
                sum += node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            a.add(sum);
        }
        int n = a.size();
        if (k > n) {
            return -1;
        }
        Collections.sort(a);
        return a.get(n - k);

    }

}
