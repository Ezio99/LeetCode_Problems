package org.hireme.leetcode.tree;

public class Balanced_Binary_Tree_110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

//        return helper(root,1)!=Integer.MAX_VALUE;

        return height(root)!=-1;



    }

    public int helper(TreeNode node,int currDepth){
        if(node==null){
            return currDepth-1;
        }
        if(node.left==null && node.right==null){
            return currDepth;
        }

        int l,r;
        l = helper(node.left,currDepth+1);
        r = helper(node.right,currDepth+1);


        if(Math.abs(l-r)>1){
            return Integer.MAX_VALUE;
        }


        return Math.max(l,r);

    }

    private int height(TreeNode node){
        if(node==null){
            return 0;
        }

        int l,r;
        l = height(node.left);

        r= height(node.right);

        if(l==-1||r==-1){
            return -1;
        }

        if(Math.abs(l-r)>1){
            return -1;
        }

        return Math.max(l,r)+1;
    }
}
