package y_2024.m01.d_10.en;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/?envType=daily-question&envId=2024-01-10">...</a>
 */
public class Solution2385 {

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

    private Map<TreeNode, TreeNode> parent = new HashMap<>();
    private TreeNode s = null;

    /**
     * 模拟感染过程，
     * DFS 先找到每个 node 的 parent，维护一个 map，并找到 start 节点
     * BFS 从 start 节点开始进行感染，求出感染完所有节点的耗时
     */
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, null, start);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(s);
        visited.add(null);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(s);
        int ans = -1;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (!visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                if (!visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode fa = parent.get(node);
                if (!visited.contains(fa)) {
                    visited.add(fa);
                    queue.offer(fa);
                }
            }
        }
        return ans;
    }

    private void dfs(TreeNode root, TreeNode fa, Integer start) {
        if (root == null) return;
        if (root.val == start) {
            s = root;
        }
        parent.put(root, fa);
        dfs(root.left, root, start);
        dfs(root.right, root, start);
    }

}
