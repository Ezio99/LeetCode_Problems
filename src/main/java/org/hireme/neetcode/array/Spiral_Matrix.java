package org.hireme.neetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int i, j;
        int modifier = 0;
        while (result.size() < n * m) {
            i = modifier; j = modifier;

            // Move left to right (top row)
            while (j < m - modifier && result.size() < n * m) {
                result.add(matrix[i][j]);
                j++;
            }

            i = modifier + 1;
            j = m - modifier - 1;

            // Move top to bottom (right column)
            while (i < n - modifier && result.size() < n * m) {
                result.add(matrix[i][j]);
                i++;
            }

            i = n - modifier - 1;
            j = m - modifier - 2;

            // Move right to left (bottom row)
            while (j >= modifier && result.size() < n * m) {
                result.add(matrix[i][j]);
                j--;
            }

            i = n - modifier - 2;
            j = modifier;

            // Move bottom to top (left column)
            while (i > modifier && result.size() < n * m) {
                result.add(matrix[i][j]);
                i--;
            }

            modifier++;
        }


        return result;
    }

    public static void main(String[] args) {
        Spiral_Matrix obj = new Spiral_Matrix();
//        System.out.println(obj.spiralOrder(new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9},
//        }));
        System.out.println(obj.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        }));
    }
}
