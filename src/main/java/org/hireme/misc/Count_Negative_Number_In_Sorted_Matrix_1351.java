package org.hireme.misc;

public class Count_Negative_Number_In_Sorted_Matrix_1351 {

    public int countNegativesOptimal(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int j = 0;
        int total = ROWS * COLS;
        for (int i = ROWS - 1; i >= 0; i--) {
            for (; j < COLS; j++) {
                if (grid[i][j] < 0) break;
                total = total - (i + 1); // all rows from 0 to i have positive in this column
            }
            if (total <= 0) break;
        }

        return total;
    }

    public int countNegatives(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int total = 0, ctr;
        for (int i = 0; i < ROWS; i++) {
            ctr = COLS;
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] < 0) break;
                ctr--;
            }
            total += ctr;
        }

        return total;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };

        Count_Negative_Number_In_Sorted_Matrix_1351 obj = new Count_Negative_Number_In_Sorted_Matrix_1351();
        System.out.println(obj.countNegativesOptimal(grid));
    }
}
