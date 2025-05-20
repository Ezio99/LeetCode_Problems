package org.hireme.neetcode.prefixsum;

public class Pivot_Index_724 {
    public int pivotIndex(int[] nums) {
        int[] prefixSumArray = new int[nums.length];

        prefixSumArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSumArray[i] = nums[i] + prefixSumArray[i - 1];
        }

        int sumL = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prefixSumArray[nums.length - 1] - prefixSumArray[i] == sumL) {
                return i;
            }
            sumL += nums[i];
        }

        return -1;

    }
}
