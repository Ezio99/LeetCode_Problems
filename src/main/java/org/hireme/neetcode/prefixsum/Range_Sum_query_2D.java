package org.hireme.neetcode.prefixsum;

import java.util.Arrays;

public class Range_Sum_query_2D {

    static class NumMatrix {

        int[][] prefixAreaMatrix;

        public NumMatrix(int[][] matrix) {
            int numRows = matrix.length, numCols = matrix[0].length;
            prefixAreaMatrix = new int[numRows+1][numCols+1];

            int sum = 0;
            for (int j = 0; j < numCols; j++) {
                sum += matrix[0][j];
                prefixAreaMatrix[0][j] = sum;
            }

            System.out.println(Arrays.toString(prefixAreaMatrix[0]));

            for (int i = 1; i < numRows; i++) {
                sum = 0; // Can be done by looking back at matrix but simpler this way
                for (int j = 0; j < numCols; j++) {
                    sum += matrix[i][j];
                    prefixAreaMatrix[i][j] += sum + prefixAreaMatrix[i - 1][j];
                }
                System.out.println(Arrays.toString(prefixAreaMatrix[i]));

            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
//            int topRight = 0, bottomLeft = 0, topLeft = 0;
//            if (row1 - 1 >= 0) {
//                topRight = prefixAreaMatrix[row1 - 1][col2];
//            }
//            if (col1 - 1 >= 0) {
//                bottomLeft = prefixAreaMatrix[row2][col1 - 1];
//            }
//            if (row1 - 1 >= 0 && col1 - 1 >= 0) {
//                topLeft = prefixAreaMatrix[row1 - 1][col1 - 1];
//            }

            return prefixAreaMatrix[row2][col2] - prefixAreaMatrix[row1 - 1][col2] - prefixAreaMatrix[row2][col1 - 1] + prefixAreaMatrix[row1 - 1][col1 - 1];
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix numMatrix = new NumMatrix(matrix);

        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // Expected: 8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // Expected: 11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // Expected: 12
    }


}
