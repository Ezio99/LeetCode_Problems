package org.hireme.playground.misc;

import java.util.*;

public class Partition_Label {


    public List<Integer> partitionLabels(String s) {
        int[] lastIndexOfCharacter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndexOfCharacter[s.charAt(i) - 'a'] = i;
        }


        int end = 0;
        List<Integer> result = new ArrayList<>();
        int wctr = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndexOfCharacter[s.charAt(i) - 'a']);
            wctr++;

            if (i == end) {
                result.add(wctr);
                wctr = 0;
            }
        }

        return result;
    }


    public List<Integer> partitionLabels2(String s) {
        HashMap<Character, Integer> characterCounts = new HashMap<>();

        char ch;
        for (int i = 0; i < s.length(); i++) {
            characterCounts.merge(s.charAt(i), 1, Integer::sum);
        }

        List<Integer> result = new ArrayList<>();
        Set<Character> characterSet = new HashSet<>();
        int wctr;
        for (int i = 0; i < s.length(); i++) {
            int charCtr = characterCounts.get(s.charAt(i));
            if (charCtr == 1) {
                result.add(1);
            } else {
                characterSet.add(s.charAt(i));
                wctr = 0;
                while (charCtr > 0) {
                    if (characterSet.contains(s.charAt(i))) {
                        charCtr--;
                    } else {
                        charCtr += characterCounts.get(s.charAt(i)) - 1;
                        characterSet.add(s.charAt(i));
                    }
                    i++;
                    wctr++;
                }
                result.add(wctr);
                i--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Partition_Label obj = new Partition_Label();
        System.out.println(obj.partitionLabels("xyxxyzbzbbisl"));
        System.out.println(obj.partitionLabels("xyxxyzbzbbislx"));
    }


}
