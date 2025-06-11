package org.hireme.neetcode.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class House_Robber {

    public int rob1(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs_1(nums, 0, cache);
    }

    private static int bottomUp_1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        //Initializing trivial cases dp so that I dont have to handle the cases in loop
        dp[n - 1] = nums[n - 1];
        //max(keep + best of next to next neighbour (out of bounds here),skip case)
        dp[n - 2] = Math.max(nums[n - 2], dp[n - 1]);

        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[0];
    }

    public int dfs_1(int[] nums, int i, int[] cache) {
        if (i >= nums.length) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }

        int skip = dfs_1(nums, i + 1, cache);

        int keep = nums[i] + dfs_1(nums, i + 2, cache);

        return cache[i] = Math.max(skip, keep);
    }

    public static void main(String[] args) {
        System.out.println(bottomUp_1(new int[]{1, 1, 3, 3}));
        System.out.println(bottomUp_1(new int[]{2, 9, 8, 3, 6}));
    }
}
