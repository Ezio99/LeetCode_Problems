package org.hireme.neetcode.graph;

public class Number_Of_Islands_DFS {
    int ROW, COL;

    public int numIslands(char[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        int numComps = 0;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == '1') {
                    numComps++;
                    dfs(i, j, grid);
                }
            }
        }

        return numComps;

    }

    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= ROW || j >= COL || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';

        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}
