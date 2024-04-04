package y_2024.m02.d_19.problem_590;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal/description/?envType=daily-question&envId=2024-02-19">...</a>
 */
public class Solution {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(Node node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        for (Node c : node.children) {
            dfs(c, ans);
        }
        ans.add(node.val);
    }
}
