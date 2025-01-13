package org.hireme.leetcode.dynamicProblems.medium;

public class Unique_Paths_2_63 {

    static int rows, cols;

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        rows = obstacleGrid.length;
        cols = obstacleGrid[0].length;
//        return helper(obstacleGrid, 0, 0, new int[rows][cols]);
        return bottomUpApproach(obstacleGrid);
    }

    private static int helper(int[][] grid, int r, int c, int[][] cache) {
        if (r == rows || c == cols || grid[r][c] == 1) {
            return 0;
        }
        if (cache[r][c] > 0) {
            return cache[r][c];
        }
        if (r == rows - 1 && c == cols - 1) {
            return 1;
        }

        cache[r][c] = helper(grid, r + 1, c, cache) + helper(grid, r, c + 1, cache);

        return cache[r][c];

    }

    private static int bottomUpApproach(int[][] obstacleGrid) {
        int[] previousRow = new int[cols];
        boolean isLastColAccessible = true;
        for (int i = rows - 1; i >= 0; i--) {
            int[] currentRow = new int[cols];
            isLastColAccessible = isLastColAccessible && obstacleGrid[i][cols - 1] == 0;
            currentRow[cols - 1] = isLastColAccessible ? 1 : 0;
            for (int j = cols - 2; j >= 0; j--) {
                currentRow[j] = obstacleGrid[i][j] == 1 ? 0 : currentRow[j + 1] + previousRow[j];
            }
            previousRow = currentRow;
        }

        return previousRow[0];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0}, {0, 1}};
        System.out.println(uniquePathsWithObstacles(grid));

    }
}
