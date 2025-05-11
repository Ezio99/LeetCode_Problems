package org.hireme.misc;

public class Merge_Sorted_Array_88 {

//    Swapping without 3rd variable
    /*
a=10b
b=01b

a = a^b
a=11b
b=01b

b=a^b
a=11b
b=10b

a=a^b
a=01b
b=10b

 */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while(j>=0){
            nums1[k--] = nums2[j--];
        }

    }

    public static void main(String[] args) {
        Merge_Sorted_Array_88 obj = new Merge_Sorted_Array_88();
        int[] x = new int[]{1, 2, 3, 0, 0, 0};
        obj.merge(x, 3, new int[]{2, 5, 6}, 3);
        for (int i : x) {
            System.out.println(i);
        }
    }
}


