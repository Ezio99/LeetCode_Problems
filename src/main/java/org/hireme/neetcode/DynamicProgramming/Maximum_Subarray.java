package org.hireme.neetcode.DynamicProgramming;

//Kadane
public class Maximum_Subarray {

    public int maxSubArray(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Maximum_Subarray obj = new Maximum_Subarray();
        System.out.println(obj.maxSubArray(new int[]{2, -3, 4, -2, 2, 1, -1, 4}));
    }


}
