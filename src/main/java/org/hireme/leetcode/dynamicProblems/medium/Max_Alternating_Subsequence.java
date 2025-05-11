package org.hireme.leetcode.dynamicProblems.medium;


public class Max_Alternating_Subsequence {
    public long maxAlternatingSum(int[] nums) {
//        return dfsHelper(0, 0, nums);
        int n = nums.length;
        long[][] cache = new long[n][2];

        return topDownHelper(0, 0, nums, cache);
    }

    private long topDownHelper(int i, int ctr, int[] nums, long[][] cache) {
        if (i >= nums.length) {
            return 0;
        }
        if (cache[i][ctr%2] != 0) {
            return cache[i][ctr%2];
        }

        long skip = topDownHelper(i + 1, ctr, nums, cache);

        long include = nums[i];

        if (ctr % 2 != 0) {
            include = -1 * include;
        }

        include += topDownHelper(i + 1, ctr + 1, nums, cache);

        cache[i][ctr%2] = Math.max(skip, include);

        return cache[i][ctr%2];

    }


    private long dfsHelper(int i, int ctr, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }

        long skip = dfsHelper(i + 1, ctr, nums);

//        long include = 0;
//        if (ctr % 2 == 0) {
//            include += nums[i] - dfsHelper(i + 1, ctr + 1, nums);
//        } else {
//            include += dfsHelper(i + 1, ctr + 1, nums) - nums[i];
//        }

        long include = nums[i];

        if (ctr % 2 != 0) {
            include = -1 * include;
        }

        // The issue with the earlier if else was the nums[i] - dfsHelper(i + 1, ctr + 1, nums);
        //Whatever i got from the function must be added to me no matter if the current is positive or negative
        include += dfsHelper(i + 1, ctr + 1, nums);


        return Math.max(skip, include);


    }

    public static void main(String[] args) {
        Max_Alternating_Subsequence obj = new Max_Alternating_Subsequence();
        System.out.println(obj.maxAlternatingSum(new int[]{4, 2, 5}));
        System.out.println(obj.maxAlternatingSum(new int[]{4, 2, 5, 3}));
    }
}
