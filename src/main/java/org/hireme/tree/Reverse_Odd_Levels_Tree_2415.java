package org.hireme.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Reverse_Odd_Levels_Tree_2415 {

    //Best solution Traversing with 2 pointers
    public TreeNode reverseOddLevelsCorrect(TreeNode root) {
        dfs(root.left, root.right, 0);
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, int depth) {
        if (left == null && right == null) return;

        if (depth % 2 == 0) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        dfs(left.left, right.right, depth + 1);
        dfs(left.right, right.left, depth + 1);
    }




    public static double logBase2(int n) {
        // log to the base a of b = log to the base x (b)/log to the base x(a)
        return Math.log(n) / Math.log(2);
    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        int ctr = 1;
        if (root.left == null) {
            return root;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> evenLevel = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left == null) {
                break;
            }
            if (Math.floor(logBase2(ctr)) % 2 == 0) {
                evenLevel.add(currentNode);

                if (Math.floor(logBase2(ctr + 1)) % 2 != 0) {
                    changeChildren(evenLevel);
                    evenLevel = new ArrayList<>();
                }
            }

            queue.add(currentNode.left);
            queue.add(currentNode.right);
            ctr++;
        }


        return root;
    }

    private static void changeChildren(List<TreeNode> evenLevelNodes) {
        int tmp;

        if (evenLevelNodes.size() == 1) {
            TreeNode node = evenLevelNodes.getFirst();
            tmp = node.left.val;
            node.left.val = node.right.val;
            node.right.val = tmp;
        }

        for (int i = 0, j = evenLevelNodes.size() - 1; i <= j; i++, j--) {
            TreeNode node1 = evenLevelNodes.get(i);
            TreeNode node2 = evenLevelNodes.get(j);
            tmp = node1.left.val;
            node1.left.val = node2.right.val;
            node2.right.val = tmp;

            tmp = node1.right.val;
            node1.right.val = node2.left.val;
            node2.left.val = tmp;

        }

    }

    public static void main(String[] args) {
//        Integer[] values = {2, 3, 5, 8, 13, 21, 34}; // Level order array
        Integer[] values = {0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}; // Level order array
        TreeNode root = TreeNode.createTree(values);

        System.out.println("Original Tree:");
        TreeNode.printTree(root);
        root = reverseOddLevels(root);

        System.out.println("Tree After Reversing Odd Levels:");
        TreeNode.printTree(root);


    }


}
