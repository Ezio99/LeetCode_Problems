package org.hireme.neetcode.DivideAndConquer;

public class Find_Minimum_Rotated_Sorted {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            // if the right half is sorted, so the minimum must be in the left half (including mid)
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        return nums[l];
    }

    public static void main(String[] args) {
        Find_Minimum_Rotated_Sorted obj = new Find_Minimum_Rotated_Sorted();
        System.out.println(obj.findMin(new int[]{2, 1}));
        System.out.println(obj.findMin(new int[]{3, 4, 5, 6, 1, 2}));
        System.out.println(obj.findMin(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
