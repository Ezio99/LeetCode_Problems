package org.hireme.leetcode.tree;

public class Subtree_Of_Another_Tree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (checkIfTreeEqual(root, subRoot)) {
                return true;
            }
        }

        boolean leftc = dfs(root.left, subRoot);
        boolean rightc = dfs(root.right, subRoot);

        return leftc || rightc;

    }

    public boolean checkIfTreeEqual(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            if (root == null && subRoot == null) {
                return true;
            }
            return false;
        }

        if (root.val == subRoot.val) {
            return checkIfTreeEqual(root.left, subRoot.left) && checkIfTreeEqual(root.right, subRoot.right);
        }

        return false;
    }
}
