package org.hireme.neetcode.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class Coin_Change {

    public int coinChange(int[] coins, int amount) {
//        return recursiveHelper(coins, amount, 0);

//        int[][] cache = new int[coins.length][amount + 1];
//        for (int i = 0; i < coins.length; i++) {
//            Arrays.fill(cache[i], -2);
//        }
//
//        int result = topDownHelper(coins, amount, 0, cache);
//        return result == Integer.MAX_VALUE ? -1 : result;

        int result = bottomUpHelper(coins, amount);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int bottomUpHelper(int[] coins, int targetAmount) {
        int[] prevRow = new int[targetAmount + 1];
        //All are impossible to get except 0 for a coin of value 0
        Arrays.fill(prevRow, Integer.MAX_VALUE);
        prevRow[0] = 0;

        int ignoreCase = 0, keepCase = 0;
        for (int coin : coins) {
            int[] newRow = new int[targetAmount + 1];
            for (int j = 1; j <= targetAmount; j++) {
                ignoreCase = prevRow[j];
                keepCase = Integer.MAX_VALUE;

                if (j - coin >= 0) {
                    if (newRow[j - coin] != Integer.MAX_VALUE) {
                        keepCase = 1 + newRow[j - coin];
                    }
                }
                newRow[j] = Math.min(ignoreCase, keepCase);
            }
            prevRow = newRow;
        }

        return prevRow[targetAmount];


    }

    private int topDownHelper(int[] coins, int targetAmount, int i, int[][] cache) {
        if (targetAmount == 0) {
            return 0;
        }
        if (i == coins.length) {
            return Integer.MAX_VALUE;
        }
        if (cache[i][targetAmount] != -2) {
            return cache[i][targetAmount];
        }

        int ignoreCase = topDownHelper(coins, targetAmount, i + 1, cache);
        int keepCase = Integer.MAX_VALUE;

        if (targetAmount - coins[i] >= 0) {
            int result = topDownHelper(coins, targetAmount - coins[i], i, cache);
            if (result != Integer.MAX_VALUE) {
                keepCase = 1 + result;
            }
        }

        cache[i][targetAmount] = Math.min(ignoreCase, keepCase);

        return cache[i][targetAmount];

    }

    //This is an example of subsets not permutation
    //e.g. for coins [1,2,3], we will get [1,2] but never [2,1]
    // This is fine for this problem because in addition/subtraction (subtraction from a number), order does not matter
    private int recursiveHelper(int[] coins, int targetAmount, int i) {
        if (targetAmount == 0) {
            return 0;
        }
        if (i == coins.length) {
            return -1;
        }

        int ignoreCase = recursiveHelper(coins, targetAmount, i + 1);
        int keepCase = 0;
        if (targetAmount - coins[i] >= 0) {
            keepCase = recursiveHelper(coins, targetAmount - coins[i], i);
            if (keepCase != -1) {
                keepCase++;
            }
        }

        if (keepCase * ignoreCase < 0) {
            return Math.max(keepCase, ignoreCase);
        }

        return Math.min(ignoreCase, keepCase);


    }


    public static void main(String[] args) {
        Coin_Change obj = new Coin_Change();
//        System.out.println(obj.coinChange(new int[]{1, 5, 10}, 12));
        System.out.println(obj.coinChange(new int[]{2, 5, 10, 1}, 27));
//        System.out.println(coinChange(new int[]{2},3));
    }


}
