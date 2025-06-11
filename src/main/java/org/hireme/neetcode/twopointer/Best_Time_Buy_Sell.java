package org.hireme.neetcode.twopointer;

public class Best_Time_Buy_Sell {
    public int maxProfit(int[] prices) {
        int profit = 0, minBuyTillNow = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minBuyTillNow > profit) {
                profit = prices[i] - minBuyTillNow;
            }
            if (prices[i] < minBuyTillNow) {
                minBuyTillNow = prices[i];
            }
        }

        return profit;
    }

    public int maxProfitSlide(int[] prices) {
        int maxP = 0;
        int l = 0, r = 1;
        while (r < prices.length) {
            if (prices[r] > prices[l]) {
                maxP = Math.max(maxP, prices[r] - prices[l]);
            }
            else {
                l=r;
            }
            r++;
        }

        return maxP;
    }
}
