package org.hireme.leetcode.dynamicProblems.easy;

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs_746 {


    static int n;

    public static int minCostClimbingStairs(int[] cost) {
        n = cost.length;
//        int[] cache = new int[n];
//        Arrays.fill(cache, -1);
//        helper(cost, 0, cache);
//        return Math.min(cache[0], cache[1]);

        return bottomUp(cost);
    }


    private static int helper(int[] cost, int stepNumber, int[] cache) {
        if (stepNumber >= cost.length) {
            return 0;
        }
        if (cache[stepNumber] != -1) {
            return cache[stepNumber];
        }


        cache[stepNumber] = cost[stepNumber] + Math.min(helper(cost, stepNumber + 1, cache),
                helper(cost, stepNumber + 2, cache));

        return cache[stepNumber];
    }


    private static int bottomUp(int[] cost) {
        int step1 = cost[0], step2 = cost[1], tmp;
        for (int i = 2; i < n; i++) {
            tmp = step2;
            step2 = cost[i] + Math.min(step1, step2);
            step1 = tmp;
        }

        return Math.min(step1, step2);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
