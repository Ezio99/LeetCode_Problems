package org.hireme.dynamicProblems;


public class Is_Subsequence_392 {


    //1 ms
    public static boolean isSubsequence(String s, String t) {

        if(s.isEmpty()){
            return true;
        }

        int pos=0;

        for(int i=0;i<t.length();i++){
            if(t.charAt(i) == s.charAt(pos)){
                if(pos>=s.length()-1){
                    pos++;
                    break;
                }
                pos++;
            }
        }

        return pos > s.length()-1;
    }



    public static void main(String[] args){
        System.out.println(isSubsequence("abc","ahbgdc"));
    }
}
