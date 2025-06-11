package org.hireme.leetcode.tree;

//NOT BST
public class Least_Common_Ancestor_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    // If p and q are found in different subtrees, the current node will receive a non-null result from both sides.
    // That means this node is their Lowest Common Ancestor (LCA).
    //
    // If p is an ancestor of q (or vice versa), only one of the recursive calls will return non-null.
    // In that case, we simply bubble up the found node itself as the answer.
    // This ensures we correctly handle cases where one node is an ancestor of the other
    public TreeNode dfs(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode == p || currentNode == q) {
            return currentNode;
        }


        TreeNode foundInLeft = dfs(currentNode.left, p, q), foundInRight = dfs(currentNode.right, p, q);
        if (foundInLeft != null && foundInRight != null) {
            return currentNode;
        }

        return foundInLeft == null ? foundInRight : foundInLeft;
    }
}
