package org.hireme.neetcode.prefixsum;

public class Range_Sum_query {

    static class NumArray {

        int[] prefixSumArray;
        public NumArray(int[] nums) {
            prefixSumArray = new int[nums.length];
            int sum = 0, ctr = 0;

            for (int num : nums) {
                sum += num;
                prefixSumArray[ctr++] = sum;
            }
        }

        public int sumRange(int left, int right) {
            int sumLeft = left == 0 ? 0 : prefixSumArray[left - 1];
            return prefixSumArray[right] - sumLeft;
        }
    }
}
