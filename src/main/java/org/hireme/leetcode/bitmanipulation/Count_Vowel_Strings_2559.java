package org.hireme.leetcode.bitmanipulation;


public class Count_Vowel_Strings_2559 {
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int vowelMask = 0;
        vowelMask = vowelMask | (1 << ('a' - 97));
        vowelMask = vowelMask | (1 << ('e' - 97));
        vowelMask = vowelMask | (1 << ('i' - 97));
        vowelMask = vowelMask | (1 << ('o' - 97));
        vowelMask = vowelMask | (1 << ('u' - 97));
        int[] isVowelWord = new int[words.length];
        int ctr = 0, vctr = 0;

        int[] result = new int[queries.length];

        for (String word : words) {
            if (((vowelMask & (1 << (word.charAt(0) - 97))) != 0) &&
                    ((vowelMask & (1 << (word.charAt(word.length() - 1) - 97))) != 0)) {
                vctr++;
            }
            isVowelWord[ctr] = vctr;
            ctr++;

        }


        int rctr = 0;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            if (start == 0) {
                result[rctr] = isVowelWord[end];
            } else {
                result[rctr] = isVowelWord[end] - isVowelWord[start - 1];
            }
            rctr++;
        }

        return result;
    }

    public static void main(String[] args) {
//        String[] words = {"apple", "orange", "banana", "avocado"};
//        int[][] queries = {
//                {0, 2},  // Range 0 to 2
//                {1, 3},  // Range 1 to 3
//                {0, 0},  // Single word range
//                {2, 2}   // Single word range
//        };

        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {
                {0, 2}, // Range [0, 2]
                {1, 4}, // Range [1, 4]
                {1, 1}  // Range [1, 1]
        };


        // Call the method and print the results
        int[] results = vowelStrings(words, queries);

        // Display results
        System.out.println("Results:");
        for (int result : results) {
            System.out.println(result);
        }
    }
}
