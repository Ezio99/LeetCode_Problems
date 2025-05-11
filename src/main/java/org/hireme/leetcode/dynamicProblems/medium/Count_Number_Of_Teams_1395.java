//package org.hireme.leetcode.dynamicProblems.medium;
//
//public class Count_Number_Of_Teams_1395 {
//    public int numTeams(int[] rating) {
//
//    }
//
//    private int dfs(int i, int j, int[] rating) {
//
//        int addScore = 0;
//        if (j - i == 2) {
//            addScore = getScore(rating[i], rating[i + 1], rating[j]);
//        }
//
//
//    }
//
//    private int getScore(int i, int j, int k) {
//        if (i < j && j < k) {
//            return 1;
//        } else if (i > j && j > k) {
//            return 1;
//        }
//        return 0;
//    }
//
//}
