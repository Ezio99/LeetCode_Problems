package org.hireme.misc;

import java.util.ArrayList;

public class Contiguous_Array_525 {


    public static int findMaxLength(int[] nums) {
        int maxLength=0,prevGroupSize=-1,currentGroupSize=0,totalGroupSize=0,prevElement=2;

        ArrayList<Integer> countOfGroups = new ArrayList<>();

        for (int i=0;i<nums.length;i++){
            if(prevElement==2 || prevElement==nums[i]){
                currentGroupSize+=1;
            }
            else{
                countOfGroups.add(currentGroupSize);
                currentGroupSize=1;
            }
            prevElement=nums[i];

        }
        countOfGroups.add(currentGroupSize);

        int start;
        for(int i=countOfGroups.size();i>0;i--){
            start=0;
            for(int j=i;j<=countOfGroups.size();j++){
                countOfGroups.subList(start,j);
            }
        }

        return maxLength;
    }

    

    public static void main(String[] args){
        int[] arr = new int[]{0,1,0,0,0,0};
        findMaxLength(arr);
    }
}
