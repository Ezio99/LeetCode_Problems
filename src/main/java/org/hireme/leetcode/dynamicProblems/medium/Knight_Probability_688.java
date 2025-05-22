package org.hireme.leetcode.dynamicProblems.medium;

import java.util.Arrays;

public class Knight_Probability_688 {

    int gridSize, depth;

    public double knightProbability(int n, int k, int row, int column) {
        gridSize = n;
        depth = k;

        double[][][] cache = new double[n][n][depth + 1];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(cache[i], -1);
//        }
        return dfs(row, column, 0, cache);
    }

    public double dfs(int i, int j, int currLevel, double[][][] cache) {
        if (i >= gridSize || i < 0 || j >= gridSize || j < 0) {
            return 0.0;
        }
        if (cache[i][j][currLevel] != 0) {
            return cache[i][j][currLevel];
        }
        if (currLevel == depth) {
            return 1.0 / (Math.pow(8.0, currLevel));
        }
        double insideBoardProb = 0;

        insideBoardProb += dfs(i + 2, j + 1, currLevel + 1, cache);
        insideBoardProb += dfs(i + 2, j - 1, currLevel + 1, cache);
        insideBoardProb += dfs(i - 2, j - 1, currLevel + 1, cache);
        insideBoardProb += dfs(i - 2, j + 1, currLevel + 1, cache);
        insideBoardProb += dfs(i + 1, j + 2, currLevel + 1, cache);
        insideBoardProb += dfs(i - 1, j + 2, currLevel + 1, cache);
        insideBoardProb += dfs(i + 1, j - 2, currLevel + 1, cache);
        insideBoardProb += dfs(i - 1, j - 2, currLevel + 1, cache);

        cache[i][j][currLevel] = insideBoardProb;

        return cache[i][j][currLevel];
    }

    public static void main(String[] args) {
        Knight_Probability_688 obj = new Knight_Probability_688();
        System.out.println(1.0 / Math.pow(8, 30));
        System.out.println(obj.knightProbability(3, 2, 0, 0));
    }
}
