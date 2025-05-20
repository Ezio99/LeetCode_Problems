package org.hireme.leetcode.tree;

import java.util.List;

public class Path_Sum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return backtrackDfs(root, targetSum);
    }

    private boolean backtrackDfs(TreeNode currentNode, int targetSum) {
        if (currentNode == null) {
            return false;
        }
        targetSum -= currentNode.val;
        if (currentNode.left == null && currentNode.right == null && targetSum == 0) {
            return true;
        }

        return backtrackDfs(currentNode.left, targetSum) || backtrackDfs(currentNode.right, targetSum);


    }

    public static void main(String[] args) {
//        Integer[] values = {1,2,3,4,5,null,8,null,null,6,7,9};
        Integer[] values = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        Path_Sum_112 obj = new Path_Sum_112();
        TreeNode root = TreeNode.createTree(values);
        System.out.println(obj.hasPathSum(root, 22));


    }
}
