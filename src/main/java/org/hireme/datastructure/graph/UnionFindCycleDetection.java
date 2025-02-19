package org.hireme.datastructure.graph;



public class UnionFindCycleDetection {
    public static void main(String[] args) {

        int a=10;
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a<<3);
        System.out.println(Integer.toBinaryString(a<<3));
        System.out.println(Integer.toBinaryString(a<<3 & ~(1<<4)) );

        int number=0b0101;
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse <<= 1;
            reverse |= (number & 1);
            number >>= 1;
        }
        System.out.println("Reversed bits: " + Integer.toBinaryString(reverse));

        int numOfNodes = 5;

        // Define the edges of the graph
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 1} // This edge creates a cycle
        };

        if (detectCycle(numOfNodes, edges)) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }
    }

    public static int find(int[] parent, int i) {
        // Note: Recursion will give slight overhead due to call stack,etc.
        // Also, kinda bad for readability
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]); // Path compression
        }

        //Or this
//        int root = i;
//        while(parent[root] != root) {
//            root = parent[root];
//        }
//
//        //Path Compression
//        int current=i,next;
//        while(parent[current] != root) {
//            next = parent[current];
//            parent[current] = root;
//            current = next;
//        }

        return parent[i];
    }

    public static void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static boolean detectCycle(int numOfNodes, int[][] edges) {
        int[] parent = new int[numOfNodes];
        int[] rank = new int[numOfNodes];

        // Initialize each node's parent to itself and rank to 0
        for (int i = 0; i < numOfNodes; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if (rootU == rootV) {
                return true; // Cycle detected
            }

            union(parent, rank, rootU, rootV);
        }

        return false; // No cycle detected
    }
}
