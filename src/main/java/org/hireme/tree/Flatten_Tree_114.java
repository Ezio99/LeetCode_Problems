package org.hireme.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Flatten_Tree_114 {
    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(list,root);

        for (int i = 0; i < list.size()-1; i++) {
            TreeNode node = list.get(i);
            node.left=null;
            node.right = list.get(i+1);
        }


        TreeNode.printTree(root);

    }

    public static void dfs(List<TreeNode> list,TreeNode node) {
        if (node == null) {
            return;
        }

        list.add(node);
        dfs(list,node.left);
        dfs(list,node.right);

    }

    public static void main(String[] args) {
        Integer[] values = {1, 2, 5, 3, 4, null, 6}; // Level order array
        TreeNode root = TreeNode.createTree(values);
        flatten(root);


    }
}
