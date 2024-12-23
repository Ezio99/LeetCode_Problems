package org.hireme.leetcode.tree;

import java.util.Stack;

public class Same_Tree_100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> callStackP = new Stack<>();
        Stack<TreeNode> callStackQ = new Stack<>();

        TreeNode currentP = p;
        TreeNode currentQ = q;

        while (!callStackP.isEmpty() || !callStackQ.isEmpty() || currentP != null || currentQ != null) {
            if (currentP == null|| currentQ == null){
                if(currentP!=currentQ){
                    return false;
                }
                currentP = callStackP.pop();
                currentQ = callStackQ.pop();

                currentP = currentP.right;
                currentQ = currentQ.right;
                continue;
            }

            if (currentP.val != currentQ.val) {
                return false;
            }

            while (currentP != null && currentQ != null) {
                callStackP.add(currentP);
                callStackQ.add(currentQ);

                currentP = currentP.left;
                currentQ = currentQ.left;

                if (currentP == null|| currentQ == null){
                    if(currentP!=currentQ){
                        return false;
                    }
                    continue;
                }

                if (currentP.val != currentQ.val) {
                    return false;
                }
            }

            //Both are null now otherwise we would have returned false in the loop
            currentP = callStackP.pop();
            currentQ = callStackQ.pop();

            currentP = currentP.right;
            currentQ = currentQ.right;

        }
        
        return true;

    }

    //Better solution - Preorder with 1 stack
    public static boolean isSameTreeBetter(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{p, q});

        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode nodeP = nodes[0];
            TreeNode nodeQ = nodes[1];

            // If both nodes are null, continue
            if (nodeP == null && nodeQ == null) {
                continue;
            }

            // If one of the nodes is null or values are different, return false
            if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val) {
                return false;
            }

            // Push right and left children to stack
            stack.push(new TreeNode[]{nodeP.right, nodeQ.right});
            stack.push(new TreeNode[]{nodeP.left, nodeQ.left});
        }

        return true;
    }



    public static void main(String[] args) {
//        Integer[] values = {1,2,3,4,5,null,8,null,null,6,7,9};
//        Integer[] values = {1,null,2,3};
        Integer[] values = {1,2,3};
        Integer[] values2 = {1,2,3};
        TreeNode root = TreeNode.createTree(values);
        TreeNode root2 = TreeNode.createTree(values2);
        boolean x = isSameTree(root, root2);
        System.out.println(x);


    }
}
