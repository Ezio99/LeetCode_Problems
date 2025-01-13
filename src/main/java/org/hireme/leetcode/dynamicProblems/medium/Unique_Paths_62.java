package org.hireme.leetcode.dynamicProblems.medium;

public class Unique_Paths_62 {
    public static int uniquePaths(int m, int n) {
//        return helperTopDown(m, n, 0, 0, new int[m][n]);
        return bottomUpApproach(m,n);
    }

    private static int helperTopDown(int m, int n, int r, int c, int[][] cache) {
        if (r == m || c == n) {
            return 0;
        }
        if (cache[r][c] > 0) {
            return cache[r][c];
        }
        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        cache[r][c] = helperTopDown(m, n, r + 1, c, cache) + helperTopDown(m, n, r, c + 1, cache);

        return cache[r][c];

    }

    //In a bottom up approach we only keep store the thing required to solve the next sub-problem
    private static int bottomUpApproach(int m, int n) {
        int[] previousRow = new int[n];
        for (int i = m - 1; i >= 0; i--) {
            int[] currentRow = new int[n];
            currentRow[n - 1] = 1;
            for (int j = n - 2; j >= 0; j--) {
                currentRow[j] = currentRow[j+1] + previousRow[j];
            }
            previousRow = currentRow;
        }

        return previousRow[0];

    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,4));
    }


}
