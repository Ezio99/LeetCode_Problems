package org.hireme.neetcode.graph;

public class Number_Of_Connected_Components {

    int[] parent;
    int[] size;
    int numComponents;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        numComponents = n;

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        return numComponents;
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) {
            return;
        }

        if (size[root1] >= size[root2]) {
            parent[root2] = root1;
            size[root1] += size[root2];
        } else {
            parent[root1] = root2;
            size[root2] += size[root1];
        }

        numComponents--;
    }

    public int find(int node) {
        int root = node;
        while (parent[root] != root) {
            root = parent[root];
        }

        //Path compression
        int tmp = parent[node];
        while (tmp != root) {
            parent[node] = root;
            node = tmp;
            tmp = parent[node];
        }

        return root;
    }


}
