package org.hireme.neetcode.DynamicProgramming;

public class Jump_Game {


    //Greedy
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            //If my index plus max I can jump can reach or surpass goal then reaching me means you can reach the goal
            //So Im the new goal
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        //If the goal is 0 it means reaching 0 means you can reach n-1
        return goal == 0;
    }


    public boolean canJumpBottomUp(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < n && dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    public boolean canJumpTopDown(int[] nums) {
        int[] cache = new int[nums.length];
        return dfs(0, nums, cache) == 1;
    }

    public int dfs(int i, int[] nums, int[] cache) {
        if (i == nums.length - 1) {
            return 1;
        }
        if (i >= nums.length) {
            return -1;
        }
        if (cache[i] != 0) {
            return cache[i];
        }


        int isExist = -1;
        for (int j = 1; j <= nums[i]; j++) {
            if (dfs(i + j, nums, cache) == 1) {
                isExist = 1;
                break;
            }
        }

        cache[i] = isExist;

        return cache[i];
    }
}
