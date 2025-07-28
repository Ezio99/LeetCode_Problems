package org.hireme.misc;

import java.util.Arrays;

public class Find_Max_Length_Valid_SubSeq_1_3201 {
    public int maximumLength(int[] nums) {
        int[][] cache = new int[nums.length][4];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(nums, -1, 0, cache);
    }

    public int dfs(int[] nums, int mod, int pos, int[][] cache) {
        if (pos >= nums.length) {
            return 0;
        }
        if (cache[pos][mod + 1] != -1) {
            return cache[pos][mod+1];
        }


        int ignore = 0;
        if (mod == -1) ignore = dfs(nums, mod, pos + 1, cache);

        int keep = 0;
        for (int i = pos + 1; i < nums.length; i++) {
            if (mod == -1) {
                keep = Math.max(keep, 2 + dfs(nums, (nums[pos] + nums[i]) % 2, i, cache));
            } else if ((nums[pos] + nums[i]) % 2 == mod) {
                keep = Math.max(keep, 1 + dfs(nums, (nums[pos] + nums[i]) % 2, i, cache));
            }
        }

        cache[pos][mod + 1] = Math.max(ignore, keep);
        return cache[pos][mod + 1];
    }

    public int maximumLengthWorks(int[] nums) {
        int res = 0;
        int[][] patterns = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
        for (int[] pattern : patterns) {
            int cnt = 0;
            for (int num : nums) {
                if (num % 2 == pattern[cnt % 2]) {
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    public static void main(String[] args) {
        Find_Max_Length_Valid_SubSeq_1_3201 obj = new Find_Max_Length_Valid_SubSeq_1_3201();
        System.out.println(obj.maximumLength(new int[]{1, 2, 3, 4}));
        System.out.println(obj.maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2}));
        System.out.println(obj.maximumLength(new int[]{1, 5, 9, 4, 2}));
    }
}
