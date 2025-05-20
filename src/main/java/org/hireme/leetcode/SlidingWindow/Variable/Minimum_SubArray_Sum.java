package org.hireme.leetcode.SlidingWindow.Variable;

public class Minimum_SubArray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0, l = 0;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                minLength = Math.min(r - l + 1, minLength);
                sum-=nums[l++];
            }
        }

        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}
