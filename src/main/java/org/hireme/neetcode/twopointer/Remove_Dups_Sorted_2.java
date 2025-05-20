package org.hireme.neetcode.twopointer;

public class Remove_Dups_Sorted_2 {
    public int removeDuplicates(int[] nums) {
        int l = 0, ctr = 0;
        boolean thresholdReached = false;

        for (int r = 1; r < nums.length; r++) {
            if (nums[l] != nums[r]) {
                thresholdReached = false;
                nums[++ctr] = nums[r];
                l = r;
            } else if (!thresholdReached) {
                nums[++ctr] = nums[r];
                thresholdReached = true;
            }
        }

        return ctr + 1;
    }

    public static void main(String[] args) {
        Remove_Dups_Sorted_2 obj = new Remove_Dups_Sorted_2();
        System.out.println(obj.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }
}
