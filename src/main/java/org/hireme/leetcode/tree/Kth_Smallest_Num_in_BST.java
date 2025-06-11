package org.hireme.leetcode.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Kth_Smallest_Num_in_BST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values, k);

        return values.get(k - 1);
    }

    public void inOrder(TreeNode node, List<Integer> values, int k) {
        if (node == null) {
            return;
        }

        inOrder(node.left, values, k);
        //We are adding smallest to largest
        // Once we reach size k we can return
        if(values.size()==k){
            return;
        }
        values.add(node.val);
        inOrder(node.right, values, k);

    }


    //Works but O(n logn)
//    public int kthSmallest(TreeNode root, int k) {
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//
//        preorder(root,k,maxHeap);
//
//        return maxHeap.poll();
//
//
//    }
//
//    public void preorder(TreeNode node, int k, PriorityQueue<Integer> maxHeap) {
//        if(node==null){
//            return;
//        }
//
//        maxHeap.offer(node.val);
//        if(maxHeap.size()>k){
//            maxHeap.poll();
//        }
//        preorder(node.left,k,maxHeap);
//
//        preorder(node.right,k,maxHeap);
//
//    }
}
