package org.hireme.neetcode.DynamicProgramming;

import java.util.Arrays;

public class Coin_Change_2 {
    public int change(int amount, int[] coins) {
//        return recursiveHelper(coins, amount, 0);

//        int[][] cache = new int[coins.length][amount + 1];
//        for (int[] row : cache) {
//            Arrays.fill(row, -1);
//        }
//
//        return topDownHelper(coins, amount, 0, cache);

        return bottomUpHelper(coins, amount);
    }

    public int botttomUp1Array(int amount, int[] coins) {
        // Number of ways to get the target
        int[] dp = new int[amount + 1];
        dp[0] = 1; // There's 1 way to make amount 0 (use no coins)

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin]; // Include current coin
            }
        }

        return dp[amount];
    }

    private int bottomUpHelper(int[] coins, int amount) {
        //Number of ways to get the target
        int[] prevRow = new int[amount + 1];
        //For coin of value 0 number of ways to get amount 0 is 1
        prevRow[0] = 1;

        int skipCase, includeCase;
        for (int i = 0; i < coins.length; i++) {
            int[] currentRow = new int[amount + 1];
            for (int j = 0; j <= amount; j++) {
                skipCase = prevRow[j];
                includeCase = 0;
                if (j - coins[i] >= 0) {
                    includeCase = currentRow[j - coins[i]];
                }
                currentRow[j] = skipCase + includeCase;
            }
            prevRow = currentRow;
        }

        return prevRow[amount];

    }

    private int topDownHelper(int[] coins, int target, int index, int[][] cache) {
        if (target == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }
        if (cache[index][target] != -1) {
            return cache[index][target];
        }

        int ignoreCase = topDownHelper(coins, target, index + 1, cache);

        int includeCase = 0;
        if (target - coins[index] >= 0) {
            includeCase = topDownHelper(coins, target - coins[index], index, cache);
        }

        cache[index][target] = includeCase + ignoreCase;

        return cache[index][target];
    }

    private int recursiveHelper(int[] coins, int target, int index) {
        if (target == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }

        int ignoreCase = recursiveHelper(coins, target, index + 1);

        int includeCase = 0;
        if (target - coins[index] >= 0) {
            includeCase = recursiveHelper(coins, target - coins[index], index);
        }

        return includeCase + ignoreCase;
    }

    public static void main(String[] args) {
        Coin_Change_2 obj = new Coin_Change_2();
        System.out.println(obj.change(4, new int[]{1, 2, 3}));
        System.out.println(obj.change(7, new int[]{2, 4}));
    }
}
