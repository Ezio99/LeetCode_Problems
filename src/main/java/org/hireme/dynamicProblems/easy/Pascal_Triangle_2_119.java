package org.hireme.dynamicProblems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal_Triangle_2_119 {
    public static List<Integer> generate(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        if(rowIndex==0){
            return Arrays.asList(1);
        }
        row.add(1);
        row.add(1);
        for(int i=2;i<=rowIndex;i++){
            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(1);
            for(int j=0;j<row.size()-1;j++){
                nextRow.add(row.get(j)+row.get(j+1));
            }
            nextRow.add(1);
            row = nextRow;
        }
        return row;
    }

    public static void main(String[] args){
        System.out.println(generate(3));
    }
}
