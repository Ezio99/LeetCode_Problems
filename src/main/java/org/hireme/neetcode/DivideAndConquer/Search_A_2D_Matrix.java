package org.hireme.neetcode.DivideAndConquer;

public class Search_A_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int searchRow = -1;
        int numRows = matrix.length, numCols = matrix[0].length;
        int l = 0, r = numRows - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][numCols - 1]) {
                searchRow = mid;
                break;
            } else if (target < matrix[mid][0]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (searchRow == -1) {
            return false;
        }

        l = 0;
        r = numCols - 1;
        while (l <= r) {
            mid = l + ((r - l) / 2);
            if (matrix[searchRow][mid] > target) {
                r = mid - 1;
            } else if (matrix[searchRow][mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        return false;


    }
}
