package org.hireme.neetcode.DynamicProgramming;

import java.util.Arrays;

public class Distinct_Subsequences {
    public int numDistinct(String s, String t) {
//        return recursiveHelper(s,t,0,0);
        int[][] cache = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(cache[i], -1);
        }

        return topDownHelper(s,t,0,0,cache);
    }

    private int recursiveHelper(String s, String t, int i1, int i2) {
        if (i2 == t.length()) {
            return 1;
        }
        if (i1 == s.length()) {
            return 0;
        }

        int ctr = 0;
        if (s.charAt(i1) == t.charAt(i2)) {
            ctr = recursiveHelper(s, t, i1 + 1, i2 + 1);
        }

        ctr += recursiveHelper(s, t, i1 + 1, i2);

        return ctr;
    }

    private int topDownHelper(String s, String t, int i1, int i2, int[][] cache) {
        if (i2 == t.length()) {
            return 1;
        }
        if (i1 == s.length()) {
            return 0;
        }
        if (cache[i1][i2] != -1) {
            return cache[i1][i2];
        }

        int ctr = 0;
        if (s.charAt(i1) == t.charAt(i2)) {
            ctr = topDownHelper(s, t, i1 + 1, i2 + 1, cache);
        }

        ctr += topDownHelper(s, t, i1 + 1, i2, cache);

        cache[i1][i2] = ctr;

        return ctr;
    }


    public static void main(String[] args) {
        Distinct_Subsequences obj = new Distinct_Subsequences();
        System.out.println(obj.numDistinct("caaat", "cat"));
        System.out.println(obj.numDistinct("xxyxy", "xy"));
    }


}
