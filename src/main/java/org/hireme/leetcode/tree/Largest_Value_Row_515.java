package org.hireme.leetcode.tree;

import java.util.*;

public class Largest_Value_Row_515 {

    public static List<Integer> largestValues(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> maxValues = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        maxValues.add(root.val);

        queue.add(root.left);
        queue.add(root.right);


        while (!queue.isEmpty()) {
            int maxValueOfLevel = -1, lengthOfQueue = queue.size();
            boolean maxExists = false;

            for (int i = 0; i < lengthOfQueue; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode == null) {
                    continue;
                }

                if (!maxExists || currentNode.val > maxValueOfLevel) {
                    maxValueOfLevel = currentNode.val;
                    maxExists = true;
                }

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            if (!maxExists) {
                break;
            }

            maxValues.add(maxValueOfLevel);
        }

        return maxValues;

    }

    public static List<Integer> largestValuesDFS(TreeNode root) {
        List<Integer> maxValues = new ArrayList<>();
        maxValues.add(null);

        dfsHelper(root, 0, maxValues);

        return maxValues;


    }

    private static void dfsHelper(TreeNode currentNode, int currentLevel, List<Integer> maxValues) {
        if (currentNode == null) {
            return;
        }

        if (maxValues.size() - 1 < currentLevel) {
            maxValues.add(null);
        }
        Integer val = maxValues.get(currentLevel);

        if (val == null || currentNode.val > val) {
            maxValues.set(currentLevel, currentNode.val);
        }

        dfsHelper(currentNode.left, currentLevel + 1, maxValues);
        dfsHelper(currentNode.right, currentLevel + 1, maxValues);


    }

    public static void main(String[] args) {
        Integer[] values = {0, -1};
        TreeNode root = TreeNode.createTree(values);
        System.out.println(largestValuesDFS(root));
    }
}
