package org.hireme.datastructure;

import java.util.Arrays;


//Find a non-empty subarray with the largest sum.
public class Kadane_Algorithm {

    public static int kadane(int[] nums) {
        int currSum = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            globalMax = Math.max(currSum, globalMax);
        }

        return globalMax;
    }

    public static int[] kadaneWindow(int[] nums) {
        int currSum = nums[0];
        int globalMax = nums[0];
        int l = 0;
        int GL = 0, GR = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currSum + nums[i]) {
                currSum = nums[i];
                l = i;
            } else {
                currSum += nums[i];
            }

            if (currSum > globalMax) {
                globalMax = currSum;
                GL = l;
                GR = i;
            }
        }

        return new int[]{GL, GR};
    }

    public static void main(String[] args) {
        System.out.println(kadane(new int[]{4, -1, 2, -7, 3, 4}));
        System.out.println(Arrays.toString(kadaneWindow(new int[]{4, -1, 2, -7, 3, 4})));
    }
}
