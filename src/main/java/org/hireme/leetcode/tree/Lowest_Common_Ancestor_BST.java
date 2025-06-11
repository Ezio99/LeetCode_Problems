package org.hireme.leetcode.tree;

//As long as we go the same path,
public class Lowest_Common_Ancestor_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }

    public TreeNode dfs(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == p || currentNode == q) {
            return currentNode;
        }

        if (p.val > currentNode.val && q.val > currentNode.val) {
            return dfs(currentNode.right, p, q);
        } else if (p.val < currentNode.val && q.val < currentNode.val) {
            return dfs(currentNode.left, p, q);
        }

        return currentNode;
    }


}
