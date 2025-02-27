package org.hireme.leetcode.dynamicProblems.medium;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum_931 {

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE, curr;

//        for (int i = 0; i < matrix[0].length; i++) {
//            curr = dfsHelper(0, i, matrix);
//            min = Math.min(curr, min);
//        }

//        int[][] cache = new int[matrix.length][matrix[0].length];
//
//        for (int i = 0; i < matrix.length; i++) {
//            Arrays.fill(cache[i], Integer.MAX_VALUE);
//        }
//
//        for (int i = 0; i < matrix[0].length; i++) {
//            curr = topDownHelper(0, i, matrix, cache);
//            min = Math.min(curr, min);
//        }
//
//        return min;

        return bottomUpHelper(matrix);

    }

    //Subproblem: For each element I need to take the minimum possible for me from the next level indexes I have access to
    //BaseCase: The last row has no elements below it (or has an imaginary row of 0s), so I can start from the level above and
    // solve the subproblem and keep going up
    private int bottomUpHelper(int[][] matrix) {
        int m = matrix.length;
        int[] prev = matrix[m - 1];
        int currMin;
        for (int i = m - 2; i >= 0; i--) {
            int[] curr = new int[m];

            for (int j = 0; j < m; j++) {
                currMin=Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    currMin = Math.min(prev[j - 1], currMin);
                }
                currMin = Math.min(prev[j], currMin);
                if (j + 1 < m) {
                    currMin = Math.min(prev[j + 1], currMin);
                }
                curr[j] = matrix[i][j] + currMin;
            }
            prev=curr;
        }

        currMin=Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if(prev[i]<currMin){
                currMin=prev[i];
            }
        }

        return currMin;


    }

    private int topDownHelper(int i, int j, int[][] matrix, int[][] cache) {
        if (j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == matrix.length - 1) {
            return matrix[i][j];
        }
        if (cache[i][j] != Integer.MAX_VALUE) {
            return cache[i][j];
        }


        //Modelling the situation and adding the condition of taking the minimum at every step (solving sub problem)
        cache[i][j] = matrix[i][j] + Math.min(topDownHelper(i + 1, j - 1, matrix, cache),
                Math.min(topDownHelper(i + 1, j, matrix, cache), topDownHelper(i + 1, j + 1, matrix, cache)));

        return cache[i][j];
    }


    private int dfsHelper(int i, int j, int[][] matrix) {
        if (j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == matrix.length - 1) {
            return matrix[i][j];
        }


        //Modelling the situation and adding the condition of taking the minimum at every step (solving sub problem)
        return matrix[i][j] + Math.min(dfsHelper(i + 1, j - 1, matrix),
                Math.min(dfsHelper(i + 1, j, matrix), dfsHelper(i + 1, j + 1, matrix)));
    }

    public static void main(String[] args) {
        Minimum_Falling_Path_Sum_931 obj = new Minimum_Falling_Path_Sum_931();
        System.out.println(obj.minFallingPathSum(new int[][]{
                {2, 1, 3}, {6, 5, 4}, {7, 8, 9}
        }));
    }
}
