package org.hireme.leetcode.tree;

public class Max_Path_Sum {
    int maxVal;

    public int maxPathSum(TreeNode root) {
        maxVal = Integer.MIN_VALUE;
        dfs(root);
        return maxVal;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            maxVal = Math.max(maxVal, node.val);
            return node.val;
        }

        int maxValLeft = dfs(node.left);
        int maxValRight = dfs(node.right);

        //Tracks actual max in all places
        maxVal = Math.max(maxVal, Math.max(node.val, Math.max(node.val + maxValLeft,
                Math.max(node.val + maxValRight, node.val + maxValRight + maxValLeft))));

        //Can only return one side's sum for max path
        return Math.max(node.val, Math.max(node.val + maxValLeft, node.val + maxValRight));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(-5);

        Max_Path_Sum sol = new Max_Path_Sum();
        int result = sol.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + result);  // Expected: 40
    }
}
