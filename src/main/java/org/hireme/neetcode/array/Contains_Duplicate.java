package org.hireme.neetcode.array;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;

public class Contains_Duplicate {
    public boolean hasDuplicate(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int num: nums){
//            if(!set.add(num)){
//                return true;
//            }
//        }
//
//        return false;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
