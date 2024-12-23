package org.hireme.leetcode.graph.medium;


import java.util.Arrays;

//Added size and numcomponents for practice, not required here
public class Redundant_Connection_684 {

    static int[] id;
//    static int[] size;

    static int numOfComponents;

    public static int[] findRedundantConnection(int[][] edges) {
        //A undirected connected graph with n nodes will have n-1 edges for MST
        // Since they added 1 edge  it becomes n
        int numberOfNodes = edges.length;

        //1-indexed nodes
        id = new int[numberOfNodes + 1];
//        size = new int[numberOfNodes + 1];

        //Might be causing some overhead
        Arrays.setAll(id, i -> i);
//        Arrays.fill(size, 1);


        for (int[] edge : edges) {
            int root0 = find(edge[0]);
            int root1 = find(edge[1]);

            if(root0==root1){
                return edge;
            }

            union(edge[0],edge[1]);
        }

        return null;
    }

    private static int find(int node) {
        int root = node;
        while (id[root] != root) {
            root = id[root];
        }

        //Path compression
        int next, current = node;
        while (id[current] != root) {
            next = id[current];
            id[current] = root;
            current = next;
        }

        return root;
    }

    private static boolean union(int nodeX, int nodeY) {
        int parentX = find(nodeX);
        int parentY = find(nodeY);

        if (parentX == parentY) {
            return true;
        }

//        if (size[parentX] > size[parentY]) {
//            id[parentY] = parentX;
//            size[parentX] += size[parentY];
//        } else {
//            id[parentX] = parentY;
//            size[parentY] += size[parentX];
//        }

        id[parentY] = parentX;
//        size[parentX] += size[parentY];

        numOfComponents--;

        return false;

    }

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 3}
        };


        // Call the findRedundantConnection method
        int[] redundantEdge = findRedundantConnection(edges);

        // Print the result
        System.out.println("The redundant edge is: [" + redundantEdge[0] + ", " + redundantEdge[1] + "]");
    }
}
