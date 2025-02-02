package org.hireme.neetcode.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class Target_Sum {

    public int findTargetSumWays(int[] nums, int target) {
//        return recursiveHelper(nums,target,0);

        //Given max sum of all nums is 1000, so if we made them all -ve and added them they will be bounded by -1000
        //But our array is relative to the target itself like we are bounded by target + sum(nums)
        int[][] cache = new int[nums.length][2001 + target];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(cache[i], -1);
        }


        return topDownHelper(nums, target, 0, cache);


    }

//    private int bottomUpHelper(int[] nums,int target){
//
//    }

    private int topDownHelper(int[] nums, int target, int i, int[][] cache) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        if (cache[i][target + 1000] != -1) {
            return cache[i][target + 1000];
        }

        cache[i][target + 1000] = topDownHelper(nums, target + nums[i], i + 1, cache) +
                topDownHelper(nums, target - nums[i], i + 1, cache);

        return cache[i][target + 1000];

    }

    private int recursiveHelper(int[] nums, int target, int i) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }


        return recursiveHelper(nums, target + nums[i], i + 1) +
                recursiveHelper(nums, target - nums[i], i + 1);

    }

    public static void main(String[] args) {
        Target_Sum obj = new Target_Sum();
        System.out.println(obj.findTargetSumWays(new int[]{2, 2, 2}, 2));

        int[] arr = new int[]{2, 107, 109, 113, 127, 131, 137, 3, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 47, 53};
        System.out.println(Arrays.stream(arr).sum());
    }
}
