package org.hireme.misc;

import java.util.Arrays;

public class Find_Max_Length_Valid_SubSeq_2_3202 {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k];
        int maxLen = 0;

        for (int i = 1; i < n; i++) {
            // Each element can start a subsequence of length 1 implicitly
            for (int j = 0; j < i; j++) {
                int mod = (nums[i] + nums[j]) % k;
                dp[i][mod] = Math.max(dp[i][mod], dp[j][mod] > 0 ? dp[j][mod] + 1 : 2);
                maxLen = Math.max(maxLen, dp[i][mod]);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Find_Max_Length_Valid_SubSeq_2_3202 obj = new Find_Max_Length_Valid_SubSeq_2_3202();
        System.out.println(obj.maximumLength(new int[]{1, 4, 2, 3, 1, 4}, 3));
    }
}
