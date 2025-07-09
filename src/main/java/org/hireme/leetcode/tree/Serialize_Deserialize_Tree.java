package org.hireme.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Serialize_Deserialize_Tree {
    List<String> encoded;
    int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        encoded = new ArrayList<>();
        encodeDfs(root);

        return String.join(",", encoded);
    }

    //Pre order
    public void encodeDfs(TreeNode node) {
        if (node == null) {
            encoded.add("n");
            return;
        }

        encoded.add(String.valueOf(node.val));
        encodeDfs(node.left);
        encodeDfs(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        index = 0;
        return decodeDfs(tokens);
    }

    public TreeNode decodeDfs(String[] s) {
        if (index >= s.length || s[index].equals("n")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(s[index++]));

        node.left = decodeDfs(s);
        node.right = decodeDfs(s);

        return node;
    }

    public static void main(String[] args) {
        Serialize_Deserialize_Tree obj = new Serialize_Deserialize_Tree();
        System.out.println(obj.deserialize("12345nnnn67nnnn"));
    }

//    public TreeNode deserialize(String data) {
//        System.out.println(data);
//        if (data.charAt(0) == 'n') {
//            return null;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        TreeNode root = new TreeNode(data.charAt(0) - 48);
//        queue.offer(root);
//
//        int i = 1;
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node == null) {
//                continue;
//            }
//
//            if (data.charAt(i) != 'n') {
//                node.left = new TreeNode(data.charAt(i) - 48);
//                queue.offer(node.left);
//            }
//            i++;
//            if (data.charAt(i) != 'n') {
//                node.right = new TreeNode(data.charAt(i) - 48);
//                queue.offer(node.right);
//            }
//            i++;
//        }
//
//        return root;
//    }
}
