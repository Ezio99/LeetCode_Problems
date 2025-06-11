package org.hireme.leetcode.tree;

public class Max_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(dfs(node.left), dfs((node.right)));
    }
}
