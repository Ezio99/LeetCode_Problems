package org.hireme.leetcode.dynamicProblems.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {

//        return dfsHelper(0, 0, grid);
        int[][] cache = new int[grid.length][grid[0].length];
        //Cache works without keeping -1 cause maybe there is no testcase with 0s in the grid or its not enough for impact
        // The effect of having 0 in the cache instead of -1 would be that in the case where the minimum number to
        // insert in the cache is 0 then in the future it could be mistaken as a path not computed yet so it will continue
        // to go into that path instead of returning 0 which is the correct value
//        return topDownHelper(0, 0, grid, cache);

        return bottomUp(grid);
    }


    //My sub problem is that at each place I want to know the best path to take to reach top left (reverse of actual problem)
    //My base case is that the top left will be included in whatever the solution
    // I can pre-compute the values of the top row and left most column as there is only 1 path for them
    //Then for each remaining cell I see what's the minimum for it in the up and left cells
    // The answer at the bottom right will be my answer
//    private int bottomUp(int[][] grid) {
//        int n = grid.length, m = grid[0].length;
//
//        int[] prev = new int[m];
//        prev[0] = grid[0][0];
//
//        for (int i = 1; i < m; i++) {
//            prev[i] = grid[0][i] + prev[i - 1];
//        }
//
//        for (int i = 1; i < n; i++) {
//            int[] dp = new int[m];
//            dp[0] = prev[0] + grid[i][0];
//            for (int j = 1; j < m; j++) {
//                dp[j] = grid[i][j] + Math.min(dp[j - 1], prev[j]);
//            }
//            prev = dp;
//        }
//
//        return prev[m - 1];
//
//    }

    public int bottomUp(int[][] grid){
        int numCols = grid[0].length,numRows = grid.length;
        int[] dp = new int[numCols];
        int[] prev = new int[numCols];

        prev[numCols-1]=grid[numRows-1][numCols-1];
        for(int i=numCols-2;i>=0;i--){
            prev[i]=grid[numRows-1][i] + prev[i+1];
        }

        for(int i=numRows-2;i>=0;i--){
            dp[numCols-1] = grid[i][numCols-1]+prev[numCols-1];
            for(int j=numCols-2;j>=0;j--){
                dp[j] = grid[i][j] + Math.min(dp[j+1],prev[j]);
            }
            prev=dp;
            dp = new int[numCols];
        }

        return prev[0];
    }

    private int topDownHelper(int i, int j, int[][] grid, int[][] cache) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        cache[i][j] = grid[i][j] + Math.min(topDownHelper(i + 1, j, grid, cache), topDownHelper(i, j + 1, grid, cache));

        return cache[i][j];
    }

    private int dfsHelper(int i, int j, int[][] grid) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        return grid[i][j] + Math.min(dfsHelper(i + 1, j, grid), dfsHelper(i, j + 1, grid));
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][]{
//                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
//        };
        int[][] grid = new int[][]{
                {1, 2, 3}, {4, 5, 6},
        };
        System.out.println(new Minimum_Path_Sum().minPathSum(grid));
    }

}
