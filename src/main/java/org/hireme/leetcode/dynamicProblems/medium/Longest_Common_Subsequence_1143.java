package org.hireme.leetcode.dynamicProblems.medium;

import java.util.Arrays;

public class Longest_Common_Subsequence_1143 {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()][text2.length()];
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }

        return helper(text1, text2, 0, 0, cache);
    }

    private static int helper(String s1, String s2, int i1, int i2, int[][] cache) {
        if (i1 > s1.length() - 1 || i2 > s2.length() - 1) {
            return 0;
        }
        if (cache[i1][i2] > -1) {
            return cache[i1][i2];
        }

        if (s1.charAt(i1) == s2.charAt(i2)) {
            cache[i1][i2] = 1 + helper(s1, s2, i1 + 1, i2 + 1, cache);
        } else {
            cache[i1][i2] = Math.max(helper(s1, s2, i1 + 1, i2, cache)
                    , helper(s1, s2, i1, i2 + 1, cache));
        }

        return cache[i1][i2];
    }



    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
