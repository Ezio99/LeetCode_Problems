package org.hireme.leetcode.tree;

public class Sorted_Array_Height_Balanced_Tree_108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return  helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int l, int r) {
        if(l>r){
            return null;
        }
        else if(l==r){
            return new TreeNode(nums[l]);
        }
        int rootIndex = (r + l) / 2;
        TreeNode node = new TreeNode(nums[rootIndex]);

        node.left = helper(nums,l,rootIndex-1);
        node.right = helper(nums,rootIndex+1,r);
        return node;
    }

    public static void main(String[] args) {
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = sortedArrayToBST(nums1);
        System.out.println("Test Case 1:");
        printTreeInOrder(root1);
        System.out.println();
    }

    // Helper method to print the tree in-order
    private static void printTreeInOrder(TreeNode root) {
        if (root == null) return;
        printTreeInOrder(root.left);
        System.out.print(root.val + " ");
        printTreeInOrder(root.right);
    }
}
