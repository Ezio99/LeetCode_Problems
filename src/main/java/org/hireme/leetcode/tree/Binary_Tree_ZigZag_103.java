package org.hireme.leetcode.tree;

import java.util.*;

public class Binary_Tree_ZigZag_103 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }


        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isOddLevel = false; // Root is level 0 even

        LinkedList<Integer> x = new LinkedList<>();
        x.addLast(4);

        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(node==null){
                    continue;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                if(isOddLevel){
                    levelList.addFirst(node.val);
                }
                else {
                    levelList.addLast(node.val);
                }

            }

            result.add(levelList);

            isOddLevel = !isOddLevel;

        }


        return result;
    }


    public static void main(String[] args) {
//        Integer[] values = {2, 3, 5, 8, 13, 21, 34}; // Level order array
//        Integer[] values = {3,9,20,null,null,15,7}; // Level order array
        Integer[] values = {1, 2, 3, 4, null, null, 5}; // Level order array
        TreeNode root = TreeNode.createTree(values);


        List<List<Integer>> x = zigzagLevelOrder(root);

        System.out.println(x);


    }

}
