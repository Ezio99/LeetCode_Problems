package org.hireme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pre_order_Trav_Iter_144 {

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
    }


    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null)
            return new ArrayList<>();


        List<Integer> nums = new ArrayList<>();
        List<TreeNode> rightNodes = new ArrayList<>();
        TreeNode x = root;

        while (true) {
            nums.add(x.val);
            if (x.left != null) {
                if (x.right != null) {
                    rightNodes.add(x.right);
                }
                x = x.left;
                continue;
            } else if (x.right != null) {
                x = x.right;
                continue;
            } else if (rightNodes.size() > 0) {
                x = rightNodes.get(rightNodes.size() - 1);
                rightNodes.remove(rightNodes.size() - 1);
                continue;
            }
            break;

        }


        return nums;

    }


    public static void main(String[] args) {
        TreeNode[] p = new TreeNode[2];
        System.out.println(Arrays.toString(p));
        System.out.println((int)'a');

    }
}
