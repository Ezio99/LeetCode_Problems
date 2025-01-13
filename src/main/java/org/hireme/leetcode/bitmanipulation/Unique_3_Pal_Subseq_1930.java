package org.hireme.leetcode.bitmanipulation;


/*
    Store indices for each character
    Then for the ones with 2 or more repeated characters, look at the max and min index
    max index -min index
    if the same char exists between them then also do -(number of repeated indexes of the character between them +1)
 */
public class Unique_3_Pal_Subseq_1930 {
    public static int countPalindromicSubsequence(String s) {
        int[][] bounds = new int[26][2];

        for (int i = 0; i < 26; i++) {
            bounds[i][0] = -1;
            bounds[i][1] = -1;
        }
        int ctr = 0;

        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) -97;
            if (bounds[pos][0] == -1) {
                bounds[pos][0]=i;
            } else {
                bounds[pos][1]=i;
            }

        }


        int mask=0,pos;
        int start,end;
        int allBitsSet = (1 << 26) - 1;
        for (int[] bound : bounds) {
            start = bound[0];
            end = bound[1];
            if (end == -1 || start - end == 1) {
                continue;
            }
            mask = 0;
            for (int i = start + 1; i < end; i++) {
                pos = s.charAt(i) - 97;
                if ((mask & (1 << pos)) == 0) {
                    mask = mask | 1 << pos;
                    ctr++;
                    //Do this or set a counter which goes up in the above if and break when it hits 26
                } else if (mask == allBitsSet) {
                    break;
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
