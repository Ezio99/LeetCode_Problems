package org.hireme.neetcode.DynamicProgramming;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = Math.max(1, dfs(nums, i, -1, dp));
        }

        return dp[0];


    }

    public int dfs(int[] nums, int i, int prevIdx, int[] dp) {
        if (i == nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int skip = dfs(nums, i + 1, prevIdx, dp);

        int keep = 0;
        if (prevIdx == -1 || nums[i] > nums[prevIdx]) {
            keep = 1 + dfs(nums, i + 1, i, dp);
        }

        return Math.max(skip, keep);
    }

    public static void main(String[] args) {
        Longest_Increasing_Subsequence obj = new Longest_Increasing_Subsequence();
        System.out.println(obj.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }


    //Top down

//    public int lengthOfLIS(int[] nums) {
//
//        int[][] cache = new int[nums.length][nums.length];
//        for (int[] arr : cache) {
//            Arrays.fill(arr, -1);
//        }
//        return dfs(nums, 0, -1, cache);
//    }
//
//    public int dfs(int[] nums, int i, int prevIdx, int[][] cache) {
//        if (i == nums.length) {
//            return 0;
//        }
//        if (cache[i][prevIdx + 1] != -1) {
//            return cache[i][prevIdx + 1];
//        }
//
//        int skip = dfs(nums, i + 1, prevIdx, cache);
//
//        int keep = 0;
//        if (prevIdx == -1 || nums[i] > nums[prevIdx]) {
//            keep = 1 + dfs(nums, i + 1, i, cache);
//        }
//
//        cache[i][prevIdx + 1] = Math.max(skip, keep);
//
//        return cache[i][prevIdx + 1];
//    }
}
