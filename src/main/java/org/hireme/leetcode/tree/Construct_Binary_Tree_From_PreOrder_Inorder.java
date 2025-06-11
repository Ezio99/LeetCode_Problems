//package org.hireme.leetcode.tree;
//
//import java.util.HashMap;
//
//
///**
// * preorder = [1,2,3,4], inorder = [2,1,3,4]
// * <p>
// * preorder[0]=root so 1 is root
// * in inorder the elements to left of 1 are in left subtree and right are in right subtree
// * However the immediate element to the right(3) or left(2) of inorder are not guaranteed to be the immediate children of 1 (i.e. root of
// * left and right subtree)
// * But the first element we encounter from those subtrees in preorder are guaranteed. Since the first element from the
// * right half we encounter in preorder is 3 we can say that 3 is right child of 1 and is the root of the right subtree
// * Same for 2
// */
//public class Construct_Binary_Tree_From_PreOrder_Inorder {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = preorder.length;
//        TreeNode root = new TreeNode(preorder[0]);
//        boolean[] visited = new boolean[n];
////        Check if the val is in right half or left half of root in inorder
//        HashMap<Integer, Integer> inValToIndex = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            inValToIndex.put(inorder[i], i);
//        }
//
//        dfs(root, 0, preorder, inorder, inValToIndex, 0, inorder.length - 1);
//
//
//        return root;
//    }
//
//    public void dfs(TreeNode node, int i, int[] preOrder, int[] inorder, HashMap<Integer, Integer> inValToIndex,
//                    int leftSubTree, int rightSubtree) {
//        if (i < 0 || i > preOrder.length) {
//            return;
//        }
//        if(inValToIndex.get(node.val))
//
//        if (i + 1 < preOrder.length && inValToIndex.get(preOrder[i + 1]) < inValToIndex.get(node.val)) {
//            node.left = new TreeNode(preOrder[i + 1]);
//            dfs(node.left, i + 1, preOrder, inorder, inValToIndex, 0, inValToIndex.get(node.val) - 1);
//        }
//
//        int rightIndex = -1;
//        //Find first preorder element in right half of inorder
//        for (int j = i + 1; j < preOrder.length; j++) {
//            if (inValToIndex.get(preOrder[j]) > inValToIndex.get(node.val)) {
//                rightIndex = j;
//                break;
//            }
//        }
//
//        if (rightIndex != -1) {
//            node.right = new TreeNode(preOrder[rightIndex]);
//            dfs(node.right, rightIndex, preOrder, inorder, inValToIndex, visited);
//        }
//
//    }
//
//
//}
