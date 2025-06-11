package org.hireme.neetcode.graph;


/**
 * A tree is a special type of acyclic graph that satisfies:
 * Acyclic: No cycles.
 * Connected: There is a path between any two nodes.
 * Exactly n−1 edges if there are nn nodes.
 */
public class Graph_Valid_Tree {

    int[] parent;
    int[] size;
    int numComponents;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        parent = new int[n];
        size = new int[n];
        numComponents = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                return false;
            }
        }

        return numComponents == 1;


    }

    public boolean union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);

        //Cycle present
        if (parent1 == parent2) {
            return true;
        }

        if (size[parent1] >= size[parent2]) {
            parent[parent2] = parent1;
            size[parent1] += size[parent2];
        } else {
            parent[parent1] = parent2;
            size[parent2] += size[parent1];
        }

        numComponents--;
        return false;


    }

    public int find(int node) {
        int root = node;
        while (root != parent[root]) {
            root = parent[root];
        }

        //Path compression
        int prev;
        while (parent[node] != root) {
            prev = parent[node];
            parent[node] = root;
            node = prev;
        }

        return root;
    }
}
