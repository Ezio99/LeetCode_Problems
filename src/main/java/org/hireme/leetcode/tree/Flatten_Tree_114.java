package org.hireme.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Flatten_Tree_114 {
    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root);



        TreeNode.printTree(root);

    }

    public static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }


        dfs(node.left);
        dfs(node.right);

    }

    public static void main(String[] args) {
        Integer[] values = {1, 2, 5, 3, 4, null, 6}; // Level order array
        TreeNode root = TreeNode.createTree(values);
        flatten(root);


    }
}
