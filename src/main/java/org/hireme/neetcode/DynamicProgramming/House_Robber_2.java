package org.hireme.neetcode.DynamicProgramming;

import java.util.Arrays;

public class House_Robber_2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        int keepFirst = dfs(nums, 0, n - 1, cache);
        Arrays.fill(cache, -1);
        int dont = dfs(nums, 1, n, cache);
        return Math.max(keepFirst, dont);
    }


    public int dfs(int[] nums, int i, int end, int[] cache) {
        if (i >= end) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }

        int skip = dfs(nums, i + 1, end, cache);

        int keep = nums[i] + dfs(nums, i + 2, end, cache);

        return cache[i] = Math.max(skip, keep);
    }

    private int bottomUp(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        //Include last house
        int prevprev, prev;
        prevprev = nums[n - 1];
        prev = Math.max(nums[n - 2], nums[n - 1]);
        int ans1 = prev;
        for (int i = n - 3; i > 0; i--) {
            ans1 = Math.max(nums[i] + prevprev, prev);
            prevprev = prev;
            prev = ans1;
        }


        prevprev = nums[n - 2];
        prev = Math.max(nums[n - 3], nums[n - 2]);
        int ans2 = prev;
        for (int i = n - 4; i >= 0; i--) {
            ans2 = Math.max(nums[i] + prevprev, prev);
            prevprev = prev;
            prev = ans2;
        }

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        House_Robber_2 obj = new House_Robber_2();
        System.out.println(obj.bottomUp(new int[]{2, 3, 2}));
    }


}
