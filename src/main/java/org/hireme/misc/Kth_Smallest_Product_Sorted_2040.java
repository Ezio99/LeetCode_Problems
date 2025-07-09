//package org.hireme.misc;
//
//public class Kth_Smallest_Product_Sorted_2040 {
//    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
//        return count(k, nums1, nums2);
//    }
//
//    //Number of combinations whose product <=x
//    public long count(long x, int[] nums1, int[] nums2) {
//        int ctr = 0;
//        int j = nums2.length - 1;
//        for (int i = 0; i < nums1.length; i++) {
//            if (nums1[i] == 0 && x >= 0) {
//                ctr += nums2.length;
//            } else if (nums1[i] < 0) {
//
//            }
//        }
//
//        return ctr;
//    }
//
//    public long binarySearch(long x, int elem, int[] nums2) {
//        int l = 0, r = nums2.length - 1, mid;
//        int modifier = 1, prod;
//        if (elem < 0) modifier = -1;
//        while (l < r) {
//            mid = l + (r - l) / 2;
//            prod = elem * nums2[mid];
//            if (prod <= x) {
//                return mid + 1;
//            }
//
//
//        }
//    }
//
//    public static void main(String[] args) {
//        Kth_Smallest_Product_Sorted_2040 obj = new Kth_Smallest_Product_Sorted_2040();
//        System.out.println(obj.kthSmallestProduct(new int[]{2, 5}, new int[]{3, 4}, 7));
//        System.out.println(obj.kthSmallestProduct(new int[]{-4, -2, 0, 3}, new int[]{2, 4}, 0));
//        System.out.println(obj.kthSmallestProduct(new int[]{-2, -1, 0, 1, 2}, new int[]{-3, -1, 2, 4, 5}, -5));
//    }
//}
