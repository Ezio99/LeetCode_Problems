package org.hireme.neetcode.DivideAndConquer;

public class BinarySearch {
    //    Already sorted
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
//        int mid = (r+l) / 2; Could give issues with overflow
//        l (offset) + (r-l)/2
        int mid = l + (r - l) / 2;
        while (l <= r) {
            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }


            mid = l + (r - l) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 2, 4, 6, 8};
        int target = 4;
        BinarySearch obj = new BinarySearch();
        System.out.println(obj.search(nums, target));
    }
}
