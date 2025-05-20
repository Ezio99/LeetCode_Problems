package org.hireme.leetcode.dynamicProblems.medium;

import java.util.Arrays;

public class Decode_Ways_91 {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return topDownHelper(s, 0, cache);
    }

    public int topDownHelper(String s, int i, int[] cache) {
        if (i == s.length()) {
            return 1;
        }
        if (cache[i] != -1) {
            return cache[i];
        }


        int numChoices = 0;
        int res = s.charAt(i) - '0';

        if (res >= 1) {
            numChoices += topDownHelper(s, i + 1, cache);
        } else {
            //Cant consider the case where 0 is a leading number
            return 0;
        }

        if (i + 1 < s.length()) {
            res = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';
            if (res <= 26) {
                numChoices += topDownHelper(s, i + 2, cache);
            }
        }

        cache[i] = numChoices;

        return cache[i];
    }

//    public int bottomUpHelper(String s) {
//        int[] dp = new int[s.length()];
//        dp[0] = s.charAt(0) != '0' ? 1 : 0;
//
//    }

    public static void main(String[] args) {
        Decode_Ways_91 obj = new Decode_Ways_91();
        System.out.println(obj.numDecodings("11106"));
    }


}
