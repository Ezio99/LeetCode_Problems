package org.hireme.neetcode.FastSlowPointers;

public class Find_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        int idx;
        for (int i = 0; i < nums.length; i++) {
            idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                return Math.abs(nums[i]);
            }
            nums[idx] = -1 * Math.abs(nums[idx]);
        }

        return 0;
    }
}
