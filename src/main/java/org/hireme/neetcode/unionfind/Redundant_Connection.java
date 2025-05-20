package org.hireme.neetcode.unionfind;

import java.util.Arrays;

public class Redundant_Connection {

    int[] parent;
    int[] rank;
    int numComponents; //Tracking for fun

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length];
        rank = new int[edges.length];
        numComponents = edges.length;

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                return edge;
            }
        }

        return null;

    }

    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return true;


        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        numComponents--;

        return false;
    }

    private int find(int i) {
        int root = i;
        // Find root
        while (parent[root] != root) {
            root = parent[root];
        }

        //Path compression
        int next = parent[i];
        while (next != root) {
            next = parent[i];
            parent[i] = root;
        }

        return root;
    }
}
