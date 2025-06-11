package org.hireme.leetcode.prefix_sum;

public class Product_Except_Self_238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] suff = new int[len];
        int prod=1;
        for (int i = len-1; i >=0; i--) {
            prod*=nums[i];
            suff[i]=prod;
        }
        prod=1;
        int[] result = new int[len];
        for (int i = 0; i < result.length-1; i++) {
            result[i]=prod*suff[i+1];
            prod*=nums[i];
        }
        result[len-1]=prod;

        return result;
    }
}
