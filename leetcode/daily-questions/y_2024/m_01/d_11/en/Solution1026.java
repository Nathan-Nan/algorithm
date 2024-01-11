package y_2024.m_01.d_11.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/?envType=daily-question&envId=2024-01-11">...</a>
 */
public class Solution1026 {

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

    /**
     * 解法一：找到每个节点的祖先节点，枚举最大差值
     */
    public int maxAncestorDiff(TreeNode root) {
        Map<TreeNode, List<TreeNode>> parents = new HashMap<>();
        dfs(root, null, parents);
        int ans = Integer.MIN_VALUE;
        for (Map.Entry<TreeNode, List<TreeNode>> entry : parents.entrySet()) {
            int val = entry.getKey().val;
            for (TreeNode node : entry.getValue()) {
                ans = Math.max(ans, Math.abs(node.val - val));
            }
        }
        return ans;
    }

    private void dfs(TreeNode root, TreeNode fa, Map<TreeNode, List<TreeNode>> parents) {
        if (root == null) {
            return;
        }
        if (fa != null) {
            List<TreeNode> list = parents.getOrDefault(root, new ArrayList<>());
            list.add(fa);
            list.addAll(parents.getOrDefault(fa, new ArrayList<>()));
            parents.put(root, list);
        }
        dfs(root.left, root, parents);
        dfs(root.right, root, parents);
    }
    
    /**
     * 解法二：记录祖先节点的最大值和最小值，求最大差值
     */
    public int maxAncestorDiff1(TreeNode root) {
        return dfs(root, root.val, root.val, 0);
    }

    private int dfs(TreeNode root, int max, int min, int diff) {
        if (root == null) {
            return diff;
        }
        diff = Math.max(diff, Math.max(Math.abs(root.val - max), Math.abs(root.val - min)));
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(Math.max(dfs(root.left, max, min, diff), dfs(root.right, max, min, diff)), diff);
    }
}
