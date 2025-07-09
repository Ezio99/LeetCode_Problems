package org.hireme.leetcode.SlidingWindow.Variable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


//Do with actual shrinking of sliding window
public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] minWindow = new int[]{0, Integer.MAX_VALUE};
        HashMap<Character, Integer> characterMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            characterMap.merge(t.charAt(i), 1, Integer::sum);
        }

        int l = 0, r = 0;
        int ctr = 0;
        char ch;
        while (r < s.length()) {
            ch = s.charAt(r);
            if (characterMap.containsKey(ch) && characterMap.get(ch) > 0) {
                ctr++;
                characterMap.merge(ch, -1, Integer::sum);
            }

            if (ctr == t.length()) {
                if (r - l + 1 < minWindow[1] - minWindow[0]) {
                    minWindow[0] = l;
                    minWindow[1] = r + 1;
                }

                while (ctr == t.length()) {
                    if (characterMap.containsKey(s.charAt(l))) {
                        ctr--;
                        characterMap.merge(s.charAt(l), 1, Integer::sum);
                        l++;
                    } else {
                        l++;
                        minWindow[0] = l;
                    }
                }
            }
            r++;
        }

        return minWindow[1] == Integer.MAX_VALUE ? "" : s.substring(minWindow[0], minWindow[1]);
    }

    public static void main(String[] args) {
        Minimum_Window_Substring obj = new Minimum_Window_Substring();
//        System.out.println(obj.minWindow("a", "a"));
        System.out.println(obj.minWindow("OUZODYXAZV", "XYZ"));
        System.out.println(obj.minWindow("ab", "a"));
    }
}
