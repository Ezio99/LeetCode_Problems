package org.hireme.neetcode.twopointer;

public class Sort_Colors_75 {

    //Bucket sort
    public void sortColors(int[] nums) {
        int[] buckets = new int[3];
        for (int i : nums) {
            buckets[i]++;
        }

        int ctr = 0;
        for (int i = 0; i < nums.length; ) {
            for (int j = 0; j < buckets[ctr]; j++) {
                nums[i++] = ctr;
            }
            ctr++;
        }
    }

    //Dutch National Flag method (DNF)
    public void sortColorsDNF(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1, tmp;

        while (mid <= high) {
            if (nums[mid] == 0) {
                tmp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = tmp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                tmp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = tmp;
                high--;
            }
        }
    }

}
