package org.hireme.leetcode.dynamicProblems.medium;

import java.util.Arrays;

public class Max_Num_Ops_Same_Score_2_3040 {

    public int maxOperations(int[] nums) {
        int n = nums.length;


//        return Math.max(recursiveHelper(2, n - 1, nums[0] + nums[1], nums),
//                Math.max(recursiveHelper(1, n - 2, nums[0] + nums[n - 1], nums),
//                        recursiveHelper(0, n - 3, nums[n - 1] + nums[n - 2], nums))) + 1;


        int[][] cache = new int[n][n];

        int f = 1, m = 1, l = 1;
        int currScore = nums[0] + nums[1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }

        f += topDownHelper(2, n - 1, nums[0] + nums[1], nums, cache);

        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }

        m += topDownHelper(1, n - 2, nums[0] + nums[n - 1], nums, cache);

        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }

        l += topDownHelper(0, n - 3, nums[n - 1] + nums[n - 2], nums, cache);


        return Math.max(f, Math.max(m, l));
    }


    private int topDownHelper(int i, int j, int score, int[] nums, int[][] cache) {
        if (j <= i || i >= nums.length) {
            return 0;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        int f = 0, m = 0, l = 0;

        if (nums[i] + nums[i + 1] == score) {
            f = 1 + topDownHelper(i + 2, j, score, nums, cache);
        }

        if (nums[i] + nums[j] == score) {
            m = 1 + topDownHelper(i + 1, j - 1, score, nums, cache);
        }

        if (nums[j] + nums[j - 1] == score) {
            l = 1 + topDownHelper(i, j - 2, score, nums, cache);
        }

        cache[i][j] = Math.max(f, Math.max(m, l));

        return cache[i][j];

    }

    private int recursiveHelper(int i, int j, int score, int[] nums) {
        if (j <= i || i >= nums.length) {
            return 0;
        }

        int f = 0, m = 0, l = 0;

        if (nums[i] + nums[i + 1] == score) {
            f = 1 + recursiveHelper(i + 2, j, score, nums);
        }

        if (nums[i] + nums[j] == score) {
            m = 1 + recursiveHelper(i + 1, j - 1, score, nums);
        }

        if (nums[j] + nums[j - 1] == score) {
            l = 1 + recursiveHelper(i, j - 2, score, nums);
        }

        return Math.max(f, Math.max(m, l));
    }

    public static void main(String[] args) {
        Max_Num_Ops_Same_Score_2_3040 obj = new Max_Num_Ops_Same_Score_2_3040();
        System.out.println(obj.maxOperations(new int[]{3, 2, 1, 2, 3, 4}));
        System.out.println(obj.maxOperations(new int[]{3, 2, 6, 1, 4}));
    }
}
