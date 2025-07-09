package org.hireme.neetcode.graph;

import java.util.*;

public class Alien_Dictionary {
    public String foreignDictionary(String[] words) {
        HashMap<Character, List<Character>> adjacencyMap = new HashMap<>();
        int[] inDegreeList = new int[26];

        for (String word : words) {
            int j;
            for (j = 0; j < word.length(); j++) {
                inDegreeList[word.charAt(j) - 'a'] = 1;
                adjacencyMap.putIfAbsent(word.charAt(j), new ArrayList<>());
            }
        }


        char ch1, ch2;
        int j;
        for (int i = 0; i < words.length - 1; i++) {
            for (j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                ch1 = words[i].charAt(j);
                ch2 = words[i + 1].charAt(j);
                if (ch1 != ch2) {
                    adjacencyMap.get(ch1).add(ch2);
                    inDegreeList[ch2 - 'a']++;
                    break;
                }
            }
            // Invalid order
            if (j == Math.min(words[i].length(), words[i + 1].length()) &&
                    words[i].length() > words[i + 1].length()) {
                return "";
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < inDegreeList.length; i++) {
            if (inDegreeList[i] == 1) {
                queue.offer((char) (i + (int) 'a'));
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            Character ch = queue.poll();
            List<Character> neighbours = adjacencyMap.getOrDefault(ch, new ArrayList<>());

            for (Character neighbour : neighbours) {
                inDegreeList[neighbour - 'a']--;
                if (inDegreeList[neighbour - 'a'] == 1) queue.offer(neighbour);
            }

            result.append(ch);
        }

        for (int i = 0; i < inDegreeList.length; i++) {
            if (inDegreeList[i] > 1) {
                return "";
            }
        }

        return result.toString();

    }

    public static void main(String[] args) {
        Alien_Dictionary obj = new Alien_Dictionary();
        System.out.println(obj.foreignDictionary(new String[]{"hrn", "hrf", "er", "enn", "rfnn"}));
    }
}
