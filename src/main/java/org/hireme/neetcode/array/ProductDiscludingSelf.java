package org.hireme.neetcode.array;

import java.util.Arrays;

public class ProductDiscludingSelf {

    public static int[] productExceptSelf(int[] nums) {
        int zeroCount=0,zeroLocation=0;
        int[] output = new int[nums.length];
        int[] prefixProduct = new int[nums.length];
        int[] postfixProduct = new int[nums.length];
        int product = 1;

        for (int i = 0; i < nums.length; i++) {

        }




        return output;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,0,1,2,3})));
    }
}
