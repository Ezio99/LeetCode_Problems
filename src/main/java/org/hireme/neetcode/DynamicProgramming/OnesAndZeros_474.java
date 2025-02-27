package org.hireme.neetcode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/ones-and-zeroes/description/
public class OnesAndZeros_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int arrLen = strs.length;
        int[][] scores = new int[arrLen][2];
        int[][][] cache = new int[arrLen][m + 1][n + 1];

        int ctr = 0;
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    scores[ctr][0]++;
                } else {
                    scores[ctr][1]++;
                }
            }
            for (int i = 0; i < cache[ctr].length; i++) {
                Arrays.fill(cache[ctr][i], -1);
            }

            ctr++;
        }


        return topDownHelper(0, m, n, scores, cache);
    }

    private int topDownHelper(int i, int m, int n, int[][] scores, int[][][] cache) {
        if (i == scores.length) {
            return 0;
        }
        if (cache[i][m][n] != -1) {
            return cache[i][m][n];
        }

        int skip = topDownHelper(i + 1, m, n, scores, cache);

        int include = 0;
        if (m - scores[i][0] >= 0 && n - scores[i][1] >= 0) {
            include = 1 + topDownHelper(i + 1, m - scores[i][0], n - scores[i][1], scores, cache);
        }

        cache[i][m][n] = Math.max(skip, include);

        return cache[i][m][n];

    }


    /**
     * Issue: Cache Does Not Account for currScore
     * <p>
     * Your cache array is defined as cache[i][m][n], meaning it only stores results based on (i, m, n).
     * However, your recursive function has an extra state variable currScore, which is not reflected in the cache.
     * This means multiple different calls with different currScore values can overwrite each other in the cache, leading to incorrect results.
     */
    //Trying i,m,n
//    private int topDownHelper(int i, int currScore, int m, int n, int[][] scores, int[][][] cache) {
//        if (i == scores.length) {
//            return currScore;
//        }
//        if (cache[i][m][n] != -1) {
//            return cache[i][m][n];
//        }
//
//        int skip = topDownHelper(i + 1, currScore, m, n, scores, cache);
//
//        int include = 0;
//        if (m - scores[i][0] >= 0 && n - scores[i][1] >= 0) {
//            include = topDownHelper(i + 1, currScore + 1, m - scores[i][0], n - scores[i][1], scores, cache);
//        }
//
//        cache[i][m][n] = Math.max(skip, include);
//
//        return cache[i][m][n];
//
//    }
    private int recursiveHelper(int i, int currScore, int m, int n, int[][] scores) {
        if (m == 0 && n == 0) {
            return currScore;
        }
        if (i == scores.length) {
            return currScore;
        }

        int skip = recursiveHelper(i + 1, currScore, m, n, scores);

        int include = 0;
        if (m - scores[i][0] >= 0 && n - scores[i][1] >= 0) {
            include = recursiveHelper(i + 1, currScore + 1, m - scores[i][0], n - scores[i][1], scores);
        }

        return Math.max(skip, include);
    }

    public static void main(String[] args) {
        OnesAndZeros_474 obj = new OnesAndZeros_474();
        System.out.println(obj.findMaxForm(new String[]{
                "10", "0001", "111001", "1", "0"
        }, 5, 3));
        System.out.println(obj.findMaxForm(new String[]{
                "10", "0", "1"
        }, 1, 1));
    }
}
