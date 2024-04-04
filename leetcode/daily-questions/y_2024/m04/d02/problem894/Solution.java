package y_2024.m04.d02.problem894;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/all-possible-full-binary-trees/description/?envType=daily-question&envId=2024-04-02">...</a>
 */
public class Solution {
    private static final List<TreeNode>[] f = new ArrayList[11];

    static {
        Arrays.setAll(f, i -> new ArrayList<>());
        f[1].add(new TreeNode());
        for (int i = 2; i < f.length; i++) { // 计算 f[i]
            for (int j = 1; j < i; j++) { // 枚举左子树叶子数
                for (TreeNode left : f[j]) { // 枚举左子树
                    for (TreeNode right : f[i - j]) { // 枚举右子树
                        f[i].add(new TreeNode(0, left, right));
                    }
                }
            }
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {
        return f[n % 2 > 0 ? (n + 1) / 2 : 0];
    }

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

}
