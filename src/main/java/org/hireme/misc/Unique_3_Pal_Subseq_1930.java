package org.hireme.misc;

import java.util.*;


/*
    Store indices for each character
    Then for the ones with 2 or more repeated characters, look at the max and min index
    max index -min index
    if the same char exists between them then also do -(number of repeated indexes of the character between them +1)
 */
public class Unique_3_Pal_Subseq_1930 {
    public static int countPalindromicSubsequence(String s) {
        HashMap<Character, int[]> characterMap = new HashMap<>();
        int ctr = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (characterMap.get(ch) == null) {
                characterMap.put(ch, new int[]{i, -1});
            } else {
                characterMap.get(ch)[1] = i;
            }

        }

        int[] currentIndices;
        int mask;
        for (Character ch : characterMap.keySet()) {
            currentIndices = characterMap.get(ch);
            if (currentIndices[1] == -1 || currentIndices[1] - currentIndices[0] == 1) {
                continue;
            }
            mask = 0;
            for (int i = currentIndices[0] + 1; i < currentIndices[1]; i++) {
                int asciiCode = s.charAt(i);
                int pos = asciiCode - 97;
                if ((mask & (1 << pos)) == 0) {
                    mask = mask | 1 << pos;
                    ctr++;
                }
            }

        }


        return ctr;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp"));
        System.out.println(countPalindromicSubsequence("bbcbaba"));
        System.out.println(countPalindromicSubsequence("aabca"));
    }


}
