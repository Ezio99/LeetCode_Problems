package org.hireme.misc;

import java.util.List;

public class Number_Of_SubArr_Bounded_795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        int ctr = 0, result = 0, maxElement = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxElement) {
                maxElement = nums[i];
            }
            if (maxElement >= left && maxElement <= right) {
                ctr++;
            } else {
                result += ctr == 0 ? 0 : (ctr*(ctr+1))/2;
                ctr = 0;
                maxElement = -1;
            }
        }
        if(ctr>0){
            result+=(ctr*(ctr+1))/2;
        }
        return result;
    }


    public static void main(String[] args) {
        Number_Of_SubArr_Bounded_795 obj = new Number_Of_SubArr_Bounded_795();
        System.out.println(obj.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
        System.out.println(obj.numSubarrayBoundedMax(new int[]{2, 9, 2, 5, 6, 7}, 2, 8));
    }


}
