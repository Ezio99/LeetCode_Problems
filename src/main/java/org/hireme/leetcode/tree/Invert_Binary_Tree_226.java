package org.hireme.leetcode.tree;

public class Invert_Binary_Tree_226 {



    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node){
        if(node==null || (node.left==null && node.right==null) ){
            return;
        }

        TreeNode tmp;
        tmp=node.left;
        node.left=node.right;
        node.right=tmp;

        invertTree(node.left);
        invertTree(node.right);
    }
}
