package org.hireme.neetcode.graph;

public class Number_Of_Islands {

    int numComponents;
    int[] parents;
    int[] size;
    int ROW, COL;
    final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        numComponents = ROW * COL;
        parents = new int[numComponents];
        size = new int[numComponents];

        for (int i = 0; i < numComponents; i++) {
            parents[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == '0') {
                    numComponents--;
                    continue;
                }
                for (int[] d : directions) {
                    int nr = i + d[0];
                    int nc = j + d[1];
                    if (nr >= 0 && nc >= 0 && nr < ROW &&
                            nc < COL && grid[nr][nc] == '1') {
                        union(i * COL + j, nr * COL + nc);
                    }
                }
            }
        }


        return numComponents;


    }

    public void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);

        if (parent1 == parent2) return;

        if (size[parent1] <= size[parent2]) {
            size[parent2] += size[parent1];
            parents[parent1] = parent2;
        } else {
            size[parent1] += size[parent2];
            parents[parent2] = parent1;
        }

        numComponents--;
    }

    public int find(int node) {
        int root = parents[node];
        while (root != parents[root]) {
            root = parents[root];
        }

        int next = parents[node];
        while (root != next) {
            next = parents[node];
            parents[node] = root;
        }

        return root;
    }


}
