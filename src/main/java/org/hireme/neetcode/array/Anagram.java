package org.hireme.neetcode.array;

import java.util.*;

public class Anagram {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, x-> new ArrayList<>()).add(strs[i]);
        }

        for(String key : map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }

    public List<List<String>> groupAnagramsAlter(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        int[] signature;

        for (int i = 0; i < strs.length; i++) {
            signature = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                signature[strs[i].charAt(j) - 'a']++;
            }
            String key = Arrays.toString(signature);

            map.computeIfAbsent(key, x-> new ArrayList<>()).add(strs[i]);
        }

        for(String key: map.keySet()){
            List<String> sub = new ArrayList<>();
            sub.addAll(map.get(key));
            result.add(sub);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
    }
}
