package org.hireme.leetcode.tree;

public class Validate_BST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean dfs(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }

        if (node.val >= left) {
            return false;
        }
        if (node.val <= right) {
            return false;
        }

        return dfs(node.left, node.val, right) && dfs(node.right, left, node.val);

    }

}
