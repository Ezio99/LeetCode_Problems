package org.hireme.misc;

public class Majority_Element_169 {

//    Boyer–Moore majority vote algorithm
    public int majorityElement(int[] nums) {
        int majNum = nums[0], ctr = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majNum) {
                ctr++;
            } else {
                ctr--;
                if (ctr == 0) {
                    majNum = nums[i];
                    ctr = 1;
                }
            }
        }

        return majNum;
    }
}
