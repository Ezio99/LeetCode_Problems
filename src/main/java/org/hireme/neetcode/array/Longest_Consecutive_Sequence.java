package org.hireme.neetcode.array;

import java.util.*;
import java.util.stream.Collectors;

public class Longest_Consecutive_Sequence {


    public static int longestConsecutive(int[] nums) {

        if(nums.length==0){
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();

        for (int i  : nums) {
            numSet.add(i);
        }

        int maxSize = 1, currentSize, ctr;

        for (int i : numSet) {
            if (!numSet.contains(i - 1)) {
                currentSize = 1;
                ctr = 1;
                while (true) {
                    if (numSet.contains(i + ctr)) {
                        currentSize++;
                        ctr++;
                    } else {
                        break;
                    }
                }
                if(currentSize>maxSize){
                    maxSize=currentSize;
                }
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{2,20,4,10,3,4,5}));
    }
}
