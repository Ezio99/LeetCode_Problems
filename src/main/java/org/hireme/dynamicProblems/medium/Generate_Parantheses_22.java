package org.hireme.dynamicProblems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generate_Parantheses_22 {
    public static List<String> generateParenthesis(int n) {
        List<List<String>> paranthesisList = new ArrayList<>();

        paranthesisList.add(Arrays.asList("()"));

        if (n == 1) {
            return paranthesisList.get(0);
        }

        paranthesisList.add(Arrays.asList("()()","(())"));

        for(int i=2;i<n;i++){
            List<String> newRow = new ArrayList<>();
            for(int j=0;j<paranthesisList.get(i-1).size();j++){
                newRow.add(paranthesisList.get(i-1).get(j)+paranthesisList.get(0).get(0));
                if(j!=0)
                    newRow.add(paranthesisList.get(0).get(0)+paranthesisList.get(i-1).get(j));
                newRow.add(overlap(paranthesisList.get(i-1).get(j)));
            }
            paranthesisList.add(newRow);
        }
        return paranthesisList.get(n-1);
    }

    public static String overlap(String s){
        return "("+s+")";
    }

//    public static List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<String>();
//        recurse(res, 0, 0, "", n);
//        return res;
//    }
//
//    public static void recurse(List<String> res, int left, int right, String s, int n) {
//        if (s.length() == n * 2) {
//            res.add(s);
//            return;
//        }
//
//        if (left < n) {
//            recurse(res, left + 1, right, s + "(", n);
//        }
//
//        if (right < left) {
//            recurse(res, left, right + 1, s + ")", n);
//        }
//    }

    public static void main(String[] args){
        System.out.println(generateParenthesis(4));
    }
}
