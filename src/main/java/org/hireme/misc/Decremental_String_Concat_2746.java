package org.hireme.misc;

import java.util.Arrays;
import java.util.HashMap;

public class Decremental_String_Concat_2746 {

    public int minimizeConcatenatedLength(String[] words) {
        HashMap<Integer, HashMap<String, String>> cache = new HashMap<>();
        String result = helper(words, words[0], 1, cache);
        return result.length();
    }

    private String helper(String[] words, String currentString, int index, HashMap<Integer, HashMap<String, String>> cache) {
        if (index == words.length) {
            return currentString;
        }
        if (cache.containsKey(index)) {
            if (cache.get(index).containsKey(currentString))
                return cache.get(index).get(currentString);
        }

        String back = helper(words, joinStrings(words[index], currentString), index + 1, cache);

        String forward = helper(words, joinStrings(currentString, words[index]), index + 1, cache);

        if (back.length() < forward.length()) {
            if (cache.containsKey(index)) {
                cache.get(index).put(currentString, back);
            } else {
                cache.put(index, new HashMap<>());
                cache.get(index).put(currentString, back);
            }
        } else {
            if (cache.containsKey(index)) {
                cache.get(index).put(currentString, forward);
            } else {
                cache.put(index, new HashMap<>());
                cache.get(index).put(currentString, forward);
            }
        }

        return cache.get(index).get(currentString);

    }

    private String joinStrings(String s1, String s2) {
        int s1Length = s1.length() - 1;
        if (s1.charAt(s1Length) == s2.charAt(0)) {
            return s1 + s2.substring(1);
        }
        return s1 + s2;
    }

    public static void main(String[] args) {
        Decremental_String_Concat_2746 obj = new Decremental_String_Concat_2746();
        System.out.println(obj.minimizeConcatenatedLength(new String[]{"b", "b", "bba", "ab", "b"}));
//        System.out.println(obj.minimizeConcatenatedLength(new String[]{"aa", "ab", "bc"}));
    }


}
