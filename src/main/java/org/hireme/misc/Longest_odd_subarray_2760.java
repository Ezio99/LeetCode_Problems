package org.hireme.misc;

public class Longest_odd_subarray_2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxL = 0, currWin;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                currWin = 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] <= threshold) {
                        if (nums[j - 1] % 2 != nums[j] % 2) {
                            currWin++;

                        }
                    } else {
                        break;
                    }
                }
                if (currWin > maxL) {
                    maxL = currWin;
                }

            }
        }
        return maxL;
    }

    public static void main(String[] args) {
        Longest_odd_subarray_2760 obj = new Longest_odd_subarray_2760();
        System.out.println(obj.longestAlternatingSubarray(new int[]{3, 2, 5, 4}, 5));
    }
}
