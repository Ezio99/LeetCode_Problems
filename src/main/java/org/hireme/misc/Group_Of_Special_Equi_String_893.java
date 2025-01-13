package org.hireme.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group_Of_Special_Equi_String_893 {
    public static int numSpecialEquivGroups(String[] words) {
        List<HashMap<String, Integer>> list = new ArrayList<>();
        List<Boolean> isInGroup = new ArrayList<>();

        for (String word : words) {
            list.add(countFrequencies(word));
            isInGroup.add(false);
        }
        int ctr = 0, ans = 1;

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if (isInGroup.get(i)) {
                continue;
            }
            for (int j = i + 1; j < list.size(); j++) {
                if (!isInGroup.get(j) && list.get(i).equals(list.get(j))) {
                    isInGroup.set(j, true);
                }
            }
            ctr++;

        }


        return ctr;
    }

    private static HashMap<String, Integer> countFrequencies(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                map.merge("*" + s.charAt(i), 1, Integer::sum);
            } else {
                map.merge("#" + s.charAt(i), 1, Integer::sum);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(numSpecialEquivGroups(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}));
    }
}
