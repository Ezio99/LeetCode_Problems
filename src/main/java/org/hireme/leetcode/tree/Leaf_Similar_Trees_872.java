package org.hireme.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.hireme.leetcode.tree.TreeNode.createTree;

public class Leaf_Similar_Trees_872 {
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafNodes = new ArrayList<>();
        List<Integer> leafNodes2 = new ArrayList<>();
        helper1(root1,leafNodes);
        helper1(root2,leafNodes2);
        return leafNodes.equals(leafNodes2);


    }

    private static void helper1(TreeNode current, List<Integer> leafNodes) {
        if(current==null){
            return;
        }
        if (current.left == null && current.right == null) {
            leafNodes.add(current.val);
            return;
        }

        helper1(current.left, leafNodes);
        helper1(current.right, leafNodes);
    }

    public static void main(String[] args) {
        // Create test cases
//        TreeNode root1 = createTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
//        TreeNode root2 = createTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, 9, 8});
//
//        // Test case 1
//        System.out.println("Test case 1: " + (leafSimilar(root1, root2) ? "Passed" : "Failed"));

        // Additional test cases
        TreeNode root3 = createTree(new Integer[]{1, 2, 3});
        TreeNode root4 = createTree(new Integer[]{1, 3, 2});
        System.out.println("Test case 2: " + (leafSimilar(root3, root4) ? "Passed" : "Failed"));

        TreeNode root5 = createTree(new Integer[]{1});
        TreeNode root6 = createTree(new Integer[]{1});
        System.out.println("Test case 3: " + (leafSimilar(root5, root6) ? "Passed" : "Failed"));

        TreeNode root7 = createTree(new Integer[]{1});
        TreeNode root8 = createTree(new Integer[]{2});
        System.out.println("Test case 4: " + (leafSimilar(root7, root8) ? "Passed" : "Failed"));
    }


}
