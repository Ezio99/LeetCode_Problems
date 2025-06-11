package org.hireme.neetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {


    //TC O(m * n)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        String key;
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            key = Arrays.toString(count);
            anagrams.computeIfAbsent(key, v -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(anagrams.values());


    }

    //TC O(m * n log n)
    public List<List<String>> groupAnagramsSorting(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        char[] arr;
        String key;
        for (String s : strs) {
            arr = s.toCharArray();
            Arrays.sort(arr);
            //Sorted string will match when two strings have the same characters and frequency of characters
            key = Arrays.toString(arr);
            anagrams.computeIfAbsent(key, v -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(anagrams.values());


    }
}
