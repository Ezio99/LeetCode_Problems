package org.hireme.leetcode.SlidingWindow.Variable;

import java.util.BitSet;
import java.util.HashMap;

public class Longest_Substring_Without_Repeat {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, l = 0;
        // Assumes input string only contains ASCII characters (0–127)
        BitSet bitSet = new BitSet(128);

        for (int r = 0; r < s.length(); r++) {
            // Move l to the point where no duplicates are present
            while (bitSet.get(s.charAt(r))) {
                bitSet.clear(s.charAt(l));
                l++;
            }

            bitSet.set(s.charAt(r));

            maxLength = Math.max(r - l + 1, maxLength);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringMap(String s) {
        int maxLength = 0, l = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }

            map.put(s.charAt(r), r);

            maxLength = Math.max(r - l + 1, maxLength);

        }

        return maxLength;
    }

    public static void main(String[] args) {
        Longest_Substring_Without_Repeat obj = new Longest_Substring_Without_Repeat();
        System.out.println(obj.lengthOfLongestSubstringMap("abba"));
    }
}
