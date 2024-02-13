package y_2024.m_02.d_13.problem_987;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/?envType=daily-question&envId=2024-02-13">...</a>
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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> groups = new TreeMap<>();
        dfs(root, 0, 0, groups);

        List<List<Integer>> ans = new ArrayList<>(groups.size());
        for (List<int[]> g : groups.values()) {
            g.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            List<Integer> vals = new ArrayList<>(g.size());
            for (int[] p : g) {
                vals.add(p[1]);
            }
            ans.add(vals);
        }
        return ans;
    }

    private void dfs(TreeNode node, int row, int col, Map<Integer, List<int[]>> groups) {
        if (node == null) {
            return;
        }
        // col 相同的分到同一组
        groups.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, node.val});
        dfs(node.left, row + 1, col - 1, groups);
        dfs(node.right, row + 1, col + 1, groups);
    }

}
