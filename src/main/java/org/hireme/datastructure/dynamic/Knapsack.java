package org.hireme.datastructure.dynamic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given a list of items, each with a weight and a profit, along with a backpack with a specified maximum capacity.
Your goal is to calculate the maximum profit you can achieve without exceeding the backpack's capacity.
You must select items such that the total weight of the items is less than or equal to the backpack's capacity.
You can select at most one of each item.
 */


public class Knapsack {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
//        int[][] cache = new int[profit.size()][capacity + 1];
//        for (int[] ints : cache) {
//            Arrays.fill(ints, -1);
//        }
//        return helper(profit, weight, capacity, 0, cache);

        return bottomUp(profit,weight,capacity);

    }

    private int helper(List<Integer> profit, List<Integer> weight, int currentCapacity, int ctr, int[][] cache) {
        if (ctr == weight.size()) {
            return 0;
        }
        if (cache[ctr][currentCapacity] != -1) {
            return cache[ctr][currentCapacity];
        }

        int skipVal = helper(profit, weight, currentCapacity, ctr + 1, cache);
        int includeVal = 0;

        if (currentCapacity - weight.get(ctr) >= 0) {
            includeVal = profit.get(ctr) + helper(profit, weight, currentCapacity - weight.get(ctr), ctr + 1, cache);
        }

        cache[ctr][currentCapacity] = Math.max(skipVal, includeVal);

        return cache[ctr][currentCapacity];


    }

    //Building up to the solution of 8 capacity and all items by solving smaller capacities and limited set of items
    //Building up to the solution by solving the same problem for smaller cases
    // e.g. so we check with 1 item what is the best we can come up to
    // Then with the third item whenever we face a situation of the best move we check which is better
    // the previous solution in which case we can ignore our current element or the current element combined with the
    // previous best solution which can be accommodated with the current element
    private int bottomUp(List<Integer> profit, List<Integer> weight, int capacity) {
        //Initially all 0 to act as a dummy where the previous best value is 0
       //+1 because we need to have the index of actual capacity instead of capacity-1
        int[] prevRow = new int[capacity+1];


        int skipVal = 0, includeVal = 0;
        for (int i = 0; i < profit.size(); i++) {
            int[] newRow = new int[capacity+1];
            //At capacity 0 profit will be 0 since no item has weight 0 to fit in a cap 0 bag
            //So we start j from 1
            for (int j = 1; j < capacity+1; j++) {
                skipVal = prevRow[j];
                includeVal = 0;
                if (j - weight.get(i) >= 0) {
                    //Profit of me + best profit i could get while having enough space for me
                    includeVal = profit.get(i) + prevRow[j - weight.get(i)];
                }
                newRow[j] = Math.max(skipVal,includeVal);
            }
            prevRow = newRow;
        }

        return prevRow[prevRow.length-1];
    }

    public static void main(String[] args) {
        Knapsack obj = new Knapsack();
        List<Integer> profit = new ArrayList<>();

        profit.add(4);
        profit.add(4);
        profit.add(7);
        profit.add(1);

        List<Integer> weight = new ArrayList<>();

        weight.add(5);
        weight.add(2);
        weight.add(3);
        weight.add(1);

        System.out.println(obj.maximumProfit(profit, weight, 8));

    }
}
