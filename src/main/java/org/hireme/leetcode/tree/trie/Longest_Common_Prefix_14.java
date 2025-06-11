package org.hireme.leetcode.tree.trie;

public class Longest_Common_Prefix_14 {

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        int j;
        for (int i = 1; i < strs.length; i++) {
            for (j = 0; j < Math.min(prefix.length(), strs[i].length()); j++) {
                if (strs[i].charAt(j) != prefix.charAt(j)) {
                    break;
                }

            }
            prefix = prefix.substring(0, j);

            if (prefix.isEmpty()) {
                break;
            }
        }

        return prefix;
    }


}
