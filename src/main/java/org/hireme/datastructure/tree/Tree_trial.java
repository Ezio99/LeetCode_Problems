package org.hireme.datastructure.tree;

public class Tree_trial {

    public static void main(String[] args) {
        Binary_Search_Tree<Integer> bst = new Binary_Search_Tree<>(null);

        // Insert nodes to create the tree
        bst.insertNode(50);
        bst.insertNode(30);
        bst.insertNode(70);
        bst.insertNode(20);
        bst.insertNode(40);
        bst.insertNode(60);
        bst.insertNode(80);

        System.out.println(bst.remove(50));



    }
}
