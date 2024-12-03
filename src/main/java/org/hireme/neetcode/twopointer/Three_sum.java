package org.hireme.neetcode.twopointer;

import java.util.List;

public class Three_sum {

    public static String twoStrings(String s1, String s2) {
        // Write your code here
        char[] ar1 = new char[s1.length()];
        s1.getChars(0,s1.length(),ar1,0);
        System.out.println(ar1);


        return s1;
    }
    public static void main(String[] args) {
        twoStrings("Hello","Hello");
    }
}
