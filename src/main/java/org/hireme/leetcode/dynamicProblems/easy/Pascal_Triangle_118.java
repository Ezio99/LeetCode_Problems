package org.hireme.leetcode.dynamicProblems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pascal_Triangle_118 {
    @org.jetbrains.annotations.NotNull
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(Collections.singletonList(1));

        if(numRows==1){
            return rows;
        }

        rows.add(Arrays.asList(1,1));
        for(int i=2;i<=numRows-1;i++){
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for(int j=0;j<rows.get(i-1).size()-1;j++){
                newRow.add(rows.get(i-1).get(j)+rows.get(i-1).get(j+1));
            }
            newRow.add(1);
            rows.add(newRow);
        }
        return rows;
    }

    public static void main(String[] args){
        System.out.println(generate(5));
    }
}
