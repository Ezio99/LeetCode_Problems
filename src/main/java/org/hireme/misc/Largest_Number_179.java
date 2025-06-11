package org.hireme.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Largest_Number_179 {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int i: nums){
            list.add(String.valueOf(i));
        }


        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1,String o2){
                // 330 vs 303 the 0vs3 makes it return 330
                return (o2+o1).compareTo(o1+o2);
            }
        });

        System.out.println(list);

        return list.stream().reduce("",(a,b)->a+b);


    }
}
