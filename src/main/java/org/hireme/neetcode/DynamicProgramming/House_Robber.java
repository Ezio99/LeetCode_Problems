package org.hireme.neetcode.DynamicProgramming;

import java.util.HashMap;

public class House_Robber {

    public static int rob(int[] nums) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(nums.length - 1, nums[nums.length - 1]);
        robHelper(0, nums, 0, cache);
        return cache.get(0);
    }

    public static int robHelper(int i, int[] nums, int robbedSoFar, HashMap<Integer, Integer> cache) {
        if (i >= nums.length) {
            return robbedSoFar;
        } else if (cache.get(i) != null) {
            return cache.get(i);
        }

        cache.put(i, Math.max(nums[i] + robHelper(i + 2, nums, robbedSoFar, cache),
                robHelper(i + 1, nums, robbedSoFar, cache)));
        return cache.get(i);
    }

    public static int robIter(int[] nums) {
        int n=nums.length;
        int prev1=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int take=nums[i]+prev2;
            int ntake=prev1;
            prev2=prev1;
            prev1=Math.max(take,ntake);
        }
        return prev1;
    }

    public static void main(String[] args) {
        System.out.println(robIter(new int[]{1, 1, 3, 3}));
        System.out.println(robIter(new int[]{2, 9, 8, 3, 6}));
    }
}
