package org.hireme.misc;

public class No_ways_split_array_2270 {
    public static int waysToSplitArray(int[] nums) {
        long sum = 0;

        for (int i : nums) {
            sum += i;
        }

        long currSum = 0;
        int ctr = 0,i=0;

        while( i < nums.length - 1) {
            currSum += nums[i];
            if (currSum >= sum - currSum) {
                ctr++;
            }
            i++;

        }

        return ctr;

    }

    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{10,4,-8,7}));
    }
}
