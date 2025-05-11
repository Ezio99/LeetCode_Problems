package org.hireme.playground.misc;

import java.util.Arrays;

public class Set_Matrix_Zeros {

    public void setZeroes(int[][] matrix) {
        boolean topRowZero = false, leftColZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        topRowZero = true;
                    }
                    if (j == 0) {
                        leftColZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (topRowZero) {
            Arrays.fill(matrix[0], 0);
        }

        if (leftColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

//    public void setZeroes(int[][] matrix) {
//        int[] rZeros = new int[matrix.length];
//        int[] cZeros = new int[matrix[0].length];
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0) {
//                    rZeros[i] = 1;
//                    cZeros[j] = 1;
//                }
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (rZeros[i] == 1 || cZeros[j] == 1) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }


//    Correct but space inefficient
//    public void setZeroes(int[][] matrix) {
//        int[][] zeroLoc = new int[matrix.length][matrix[0].length];
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0) {
//                    zeroLoc[i][j] = 1;
//                }
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (zeroLoc[i][j]==1) {
//                    setRowAndColZero(i,j,matrix);
//                }
//            }
//        }
//
//    }
//
//    public void setRowAndColZero(int r, int c, int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            matrix[i][c] = 0;
//        }
//
//        for (int i = 0; i < matrix[0].length; i++) {
//            matrix[r][i] = 0;
//        }
//    }
}
