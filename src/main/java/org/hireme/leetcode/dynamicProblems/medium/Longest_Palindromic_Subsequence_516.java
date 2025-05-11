package org.hireme.leetcode.dynamicProblems.medium;

public class Longest_Palindromic_Subsequence_516 {
    public int longestPalindromeSubseq(String s) {
//        int maxV = 0, currV;
//        for (int i = 0; i < s.length(); i++) {
//            currV = dfs(s, i, i);
//            if (currV > maxV) {
//                maxV = currV;
//            }
//        }
//        return maxV;

        int maxV = 0, currV;
        int[][] cache = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            currV = topDownHelper(s, i, i, cache);
            if (currV > maxV) {
                maxV = currV;
            }
        }
        return maxV;
    }

    public int topDownHelper(String s, int l, int r, int[][] cache) {
        if (l < 0 || r > s.length() - 1) {
            return 0;
        }
        if (cache[l][r] != 0) {
            return cache[l][r];
        }

        int maxL = 0, maxR = 0, maxB = 0;
        if (s.charAt(l) == s.charAt(r)) {
            maxL = 1 + topDownHelper(s, l - 1, r, cache);
            maxR = 1 + topDownHelper(s, l, r + 1, cache);
            maxB = 1 + topDownHelper(s, l - 1, r + 1, cache);
        }

        cache[l][r] = Math.max(maxL, Math.max(maxR, maxB));

        return cache[l][r];
    }

    public int dfs(String s, int l, int r) {
        if (l < 0 || r > s.length() - 1) {
            return 0;
        }

        int maxL = 0, maxR = 0, maxB = 0;
        if (s.charAt(l) == s.charAt(r)) {
            maxL = 1 + dfs(s, l - 1, r);
            maxR = 1 + dfs(s, l, r + 1);
            maxB = 1 + dfs(s, l - 1, r + 1);
        }

        return Math.max(maxL, Math.max(maxR, maxB));
    }

    public static void main(String[] args) {
        Longest_Palindromic_Subsequence_516 obj = new Longest_Palindromic_Subsequence_516();
        System.out.println(obj.longestPalindromeSubseq("bbbab"));
    }


}
