package org.hireme.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

//Common TreeNode class used in Leetcode for tree problems
public class TreeNode {


    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] values) {
        if (values == null || values.length == 0) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();
            if (current != null) {
                if (i < values.length && values[i] != null) {
                    current.left = new TreeNode(values[i]);
                    queue.offer(current.left);
                }
                i++;
                if (i < values.length && values[i] != null) {
                    current.right = new TreeNode(values[i]);
                    queue.offer(current.right);
                }
                i++;
            }
        }

        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                System.out.print((current != null ? current.val : "null") + " ");
                if (current != null) {
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
            System.out.println();
        }
    }
}

