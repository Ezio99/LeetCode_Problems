package org.hireme.leetcode.dynamicProblems.easy;


/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a
different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

If I buy on day x what is the max profit? Cache that
[1,2,3]
 If I buy on day 3, profit is 0, if I buy on day 2, profit is 0 or -1, so we keep the maximum which is 0
 And if I buy on day 1 profit is


[3,2,5,2]
Buy on day 4 (2) profit 0, keep 0
Buy on day 3 (5) profit 3 or 0,keep 3
Buy on day 2 (2) profit 3 or 0,keep 3

 */


import java.util.Arrays;

public class Best_Time_To_Buy_And_Sell_121 {
    public static int maxProfit(int[] prices) {

        //Greedy solution also works
//        int minPrice = prices[0], maxProf = 0;
//
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] < minPrice) {
//                minPrice=prices[i];
//            }
//            else{
//                maxProf = Math.max(maxProf,prices[i]-minPrice);
//
//            }
//        }
//
//        return maxProf;


        int n = prices.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);  // Initialize memoization table
        return helper(prices, 0, Integer.MAX_VALUE, memo);
    }

    private static int helper(int[] prices, int day, int minPrice, int[] memo) {
        if (day == prices.length) {
            return 0; // Base case: no more days left
        }
        if (memo[day] != -1) {
            return memo[day]; // Return cached result
        }

        // Update the minimum price so far
        minPrice = Math.min(minPrice, prices[day]);

        // Decide whether to sell on this day or skip it
        int sellToday = prices[day] - minPrice;   // Profit from selling today
        int skipToday = helper(prices, day + 1, minPrice, memo); // Profit from skipping today

        // Store the maximum profit in the memo table
        memo[day] = Math.max(sellToday, skipToday);
        return memo[day];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));

    }
}
