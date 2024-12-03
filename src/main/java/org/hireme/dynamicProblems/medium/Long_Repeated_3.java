package org.hireme.dynamicProblems.medium;

import java.util.*;

public class Long_Repeated_3 {

    public static int lengthOfLongestSubstring(String s) {

        if(s.isEmpty()){
            return 0;
        }

        String[] stringArray = s.split("");
        Set<String> seenCharacters = new HashSet<>();
        int ctr=0,mnum=0;
        for(int i=0;i<stringArray.length;i++){
            if(!seenCharacters.contains(stringArray[i])){
                seenCharacters.add(stringArray[i]);
                ctr++;
            }
            else {
                if(ctr>mnum){
                    mnum=ctr;
                }
                seenCharacters.clear();
                ctr=1;
                seenCharacters.add(stringArray[i]);
            }

        }

        if(ctr>mnum){
            mnum=ctr;
        }

        return mnum;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabc"));
    }
}
