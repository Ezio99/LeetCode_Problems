package org.hireme.neetcode.DynamicProgramming;

import java.util.Arrays;

public class Partition_Equal_Subset_Sum {

    static int totalSum;
    static int targetSum;

    public static boolean canPartition(int[] nums) {
        totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0) {
            return false;
        }
        targetSum = totalSum / 2;

        int[][] cache = new int[nums.length][totalSum];

//        return topDownHelper(nums, 0, 0, cache);

//        return revursiveHelper(nums, 0, 0);

        return bottomUpHelper(nums);

    }

    //Building up to the solution by solving the same problem for smaller cases
    // We reduced the problem to a target sum problem then started building up to it
    // e.g. Target sum 5, so we check with 1 item what is the best we can come up to
    // Then with the third item whenever we face a situation of the best move we check which is better
    // if its the previous solution in which case we can ignore our current element or the current element combined with the
    // previous best solution which can be accommodated with the current element
    private static boolean bottomUpHelper(int[] nums) {
        boolean[] prevRow = new boolean[targetSum + 1];
        prevRow[0] = true;

        //Each array keeps track of whether or not we reached the target sum of that index
        boolean skipval, keepVal;
        for (int i = 0; i < nums.length; i++) {
            boolean[] newRow = new boolean[targetSum + 1];
            newRow[0] = true;
            for (int j = 1; j <= targetSum; j++) {
                //If I don't include the current element what was the previous result
                skipval = prevRow[j];
                // prevRow[j - nums[i]] - e.g. j=3, nums[i]=2, did we achieve 1 in prevrow[1]? Yes then this will also be true
                keepVal = j - nums[i] >= 0 ? prevRow[j - nums[i]] : false;
                newRow[j] = skipval || keepVal;
            }
            prevRow = newRow;

            if (newRow[targetSum]) {
                return true;
            }
        }

        return false;
    }

    private static boolean topDownHelper(int[] nums, int i, int currentSum, int[][] cache) {
        if (i >= nums.length) {
            return false;
        }
        if (currentSum > targetSum) {
            return false;
        }
        if (currentSum == targetSum) {
            return true;
        }
        if (cache[i][currentSum] == -1) {
            return false;
        }


        cache[i][currentSum] = -1;

        return topDownHelper(nums, i + 1, currentSum, cache) || topDownHelper(nums, i + 1, currentSum + nums[i], cache);


    }

    private static boolean revursiveHelper(int[] nums, int i, int currentSum) {
        if (i >= nums.length) {
            return false;
        }
        //All positive so can only increase so will never be equal
        if (currentSum > targetSum) {
            return false;
        }

        if (currentSum == targetSum) {
            return true;
        }

        return revursiveHelper(nums, i + 1, currentSum) || revursiveHelper(nums, i + 1, currentSum + nums[i]);

    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }
}
