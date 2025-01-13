package org.hireme.neetcode.prefixsum;

public class Range_Sum_query_2D {

    static class NumMatrix {

        int[][] prefixSumArray;

        public NumMatrix(int[][] matrix) {
            int numOfRows = matrix.length, numOfCols = matrix[0].length;
            prefixSumArray = new int[numOfRows][numOfCols];

            int aboveValue, leftValue;

            for (int i = 0; i < numOfRows; i++) {
                for (int j = 0; j < numOfCols; j++) {
                    aboveValue = i == 0 ? 0 : prefixSumArray[i - 1][j];
                    leftValue = j == 0 ? 0 : prefixSumArray[i][j - 1];

                    prefixSumArray[i][j] = matrix[i][j] + aboveValue + leftValue;
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixSumArray[row2][col2] - prefixSumArray[row1][col2] - prefixSumArray[row2][col1];
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
