package org.hireme.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder_Iterative_94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> callStack = new Stack<>();
        Stack<Boolean> backTrackStack = new Stack<>();

        if (root == null) {
            return new ArrayList<>();
        }

        callStack.add(root);
        backTrackStack.add(false);

        while (!callStack.isEmpty()) {
            TreeNode currentNode = callStack.peek();
            boolean isBackTracking = backTrackStack.peek();

            if (isBackTracking) {
                result.add(currentNode.val);
                callStack.pop();
                backTrackStack.pop();

                if (currentNode.right != null) {
                    callStack.add(currentNode.right);
                    backTrackStack.add(false);
                }
            } else {
                backTrackStack.pop();
                backTrackStack.add(true);

                if (currentNode.left != null) {
                    callStack.add(currentNode.left);
                    backTrackStack.add(false);
                }

            }
        }

        return result;
    }

    public List<Integer> inorderTraversal1s(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse the left subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Process the current node
            current = stack.pop();
            result.add(current.val);

            // Traverse the right subtree
            current = current.right;
        }

        return result;
    }


    public static void main(String[] args) {
//        Integer[] values = {1,2,3,4,5,null,8,null,null,6,7,9};
//        Integer[] values = {1,null,2,3};
        Integer[] values = {};
        TreeNode root = TreeNode.createTree(values);
        List<Integer> x = inorderTraversal(root);
        System.out.println(x);


    }

}
