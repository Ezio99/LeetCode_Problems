package org.hireme.neetcode.DynamicProgramming.beautiful;

import java.util.Arrays;

public class Beautiful_String {
    public int minReplaceBeautifulString(String s) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return dfs(0, s, cache);
    }

    public int dfs(int i, String s, int[] cache) {
        if (i >= s.length() - 1) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }
        int diff = Math.abs(s.charAt(i) - s.charAt(i + 1));

        int replace = 0;
        if (diff <= 1) {
            replace = 1 + Math.min(dfs(i + 1, s, cache), dfs(i + 2, s, cache));
        } else {
            replace = dfs(i + 1, s, cache);
        }

        cache[i] = replace;

        return cache[i];

    }

    public static void main(String[] args) {
        String[] testCases = {
                "abdde",     // Example from prompt
                "abcdef",    // Has adjacent alphabet characters
                "azazaz",    // Already beautiful
                "aabbcc",    // Has repeated characters
                "mnopqr",    // Has adjacent alphabet characters
                "xyzabc"     // Edge case: wraparound adjacency
        };

        Beautiful_String obj = new Beautiful_String();

        for (String testCase : testCases) {
            int result = obj.minReplaceBeautifulString(testCase);
            System.out.println("Input: " + testCase + " → Minimum operations: " + result);
        }
    }

}
