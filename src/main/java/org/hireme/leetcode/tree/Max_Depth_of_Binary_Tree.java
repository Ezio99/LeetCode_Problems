package org.hireme.leetcode.tree;

public class Max_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return dfs(root,1);
    }

    private int dfs(TreeNode node,int currDepth){
        if(node.left==null && node.right==null){
            return currDepth;
        }

        int l=1,r=1;
        if(node.left!=null){
            l=dfs(node.left,currDepth+1);
        }
        if(node.right!=null){
            r=dfs(node.right,currDepth+1);
        }

        return Math.max(l,r);

    }
}
