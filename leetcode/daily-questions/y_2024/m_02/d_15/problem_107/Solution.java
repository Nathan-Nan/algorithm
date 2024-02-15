package y_2024.m_02.d_15.problem_107;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/description/?envType=daily-question&envId=2024-02-15">...</a>
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // bfs(root);
        dfs(root, 0);
        Collections.reverse(ans);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();

    private void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }
        dfs(node.left, level + 1);
        ans.get(level).add(node.val);
        dfs(node.right, level + 1);

    }

    private void bfs(TreeNode node) {
        if (node == null) return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            ans.add(0, list);
        }

    }

}
