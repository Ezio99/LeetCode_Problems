package org.hireme.neetcode.prefixsum;

import java.util.HashMap;

//Prefix sum and hashmap combined usage
public class Subarray_Sum_Equals_K {

    public static int subarraySumBruteForce(int[] nums, int k) {
        int[] prefixSumArray = new int[nums.length];
        int numOfAnswers = 0, ctr = 0, sum = 0;

        for (int i : nums) {
            numOfAnswers += i == k ? 1 : 0;
            sum += i;
            prefixSumArray[ctr++] = sum;
        }

        int currSum;
        for (int i = 1; i < nums.length; i++) {
            int prev = 0;
            for (int j = i; j < nums.length; j++) {
                currSum = prefixSumArray[j] - prev;
                numOfAnswers += currSum == k ? 1 : 0;
                prev = prefixSumArray[j - i];
            }
        }

        return numOfAnswers;
    }

    public static int subarraySumOptimized(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumFrequency = new HashMap<>();
        //Putting this for the case of getting the sum, it should be counted as 1
        prefixSumFrequency.put(0, 1);
        int result = 0, current = 0, sum = 0;

        for (int num : nums) {
            sum += num;
            // We want to find how many times (sum - k) has occurred
            int target = sum - k;
            if (prefixSumFrequency.containsKey(target)) {
                result += prefixSumFrequency.get(target);
            }
            // Record the current prefix sum
            prefixSumFrequency.merge(sum, 1, Integer::sum);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subarraySumOptimized(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySumOptimized(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySumOptimized(new int[]{1, 1, 1, 1, 1}, 2));
    }


}
