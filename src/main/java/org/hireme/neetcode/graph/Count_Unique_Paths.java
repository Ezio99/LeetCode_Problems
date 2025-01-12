package org.hireme.neetcode.graph;

public class Count_Unique_Paths {

    static int rows, cols;

    public static int countPaths(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        return helperDFS(grid, 0, 0, new int[rows][cols]);
    }

    private static int helperDFS(int[][] grid, int r, int c, int[][] visited) {
        if (Math.min(r, c) < 0
                || r == rows
                || c == cols
                || visited[r][c] == 1
                || grid[r][c] == 1) {
            return 0;
        }
        if (r == rows - 1 && c == cols - 1) {
            return 1;
        }

        int ctr = 0;
        visited[r][c] = 1;
        ctr += helperDFS(grid, r + 1, c, visited);//Down
        ctr += helperDFS(grid, r - 1, c, visited);//Up
        ctr += helperDFS(grid, r, c + 1, visited);//Right
        ctr += helperDFS(grid, r, c - 1, visited);//Left
        visited[r][c] = 0;


        return ctr;

    }
}
