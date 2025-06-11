package org.hireme.neetcode.string;

public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freqArr = new int[26];
        int sIndex, tIndex;
        for (int i = 0; i < s.length(); i++) {
            sIndex = s.charAt(i) - 'a';
            tIndex = t.charAt(i) - 'a';
            freqArr[sIndex]++;
            freqArr[tIndex]--;
        }

        for (int i : freqArr) {
            if (i != 0) return false;
        }

        return true;
    }
}
