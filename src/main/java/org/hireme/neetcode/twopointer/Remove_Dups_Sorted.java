package org.hireme.neetcode.twopointer;

public class Remove_Dups_Sorted {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int l = 0, ctr = 0;

        for (int r = 1; r < nums.length; r++) {
            if (nums[l] != nums[r]) {
                nums[++ctr] = nums[r];
                l = r;
            }
        }

        return ctr +1;
    }

    public static void main(String[] args) {
        Remove_Dups_Sorted obj = new Remove_Dups_Sorted();
        System.out.println(obj.removeDuplicates(new int[]{1,1,2,3,4}));
    }
}
