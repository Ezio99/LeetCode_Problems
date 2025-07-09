package org.hireme.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class String_Matching_In_Array_1408 {
    //KMP - Knuth Morris Pratt
//    public List<String> stringMatching(String[] words) {
////        List<int[]> lps = new ArrayList<>();
//        int[] lps;
//        HashSet<String> lpsSupport;
//        for (int i = 0; i < words.length; i++) {
//            lps = new int[words[i].length() + 1];
//            lps[1] = 0;
//            lpsSupport = new HashSet<>();
//            lpsSupport.add(String.valueOf(words[i].charAt(0)));
//            for (int j = 1; j < words[i].length(); j++) {
//
//            }
//        }
//
//    }

    //Brute force
    public List<String> stringMatchingBrute(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j != i && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }
}
