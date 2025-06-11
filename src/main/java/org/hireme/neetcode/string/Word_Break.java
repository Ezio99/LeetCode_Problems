package org.hireme.neetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int[] cache = new int[s.length()];
        return dfs(0, 0, s, set, cache) == 1;
    }

    public int dfs(int l, int r, String s, HashSet<String> set, int[] cache) {
        if (r >= s.length()) {
            return -1;
        }
        if (cache[l] != 0) {
            return cache[l];
        }

        int ignore = dfs(l, r + 1, s, set, cache);
        int keep = -1;

        if (set.contains(s.substring(l, r + 1))) {
            if (r == s.length() - 1) {
                return 1;
            } else {
                keep = dfs(r + 1, r + 1, s, set, cache);
            }
        }

        cache[l] = Math.max(keep, ignore);

        return cache[l];

    }

    public static void main(String[] args) {
        Word_Break obj = new Word_Break();
        List<String> strings = new ArrayList<>();
        strings.add("neet");
        strings.add("code");
        System.out.println(obj.wordBreak("neetscode", strings));
    }

//Greedy approach wont work
    //        int l = 0, r = 0;
//        boolean flag = false;
//        String curr;
//        while (r < s.length()) {
//            curr = s.substring(l, r + 1);
//            if (set.contains(curr)) {
//                flag = r == s.length() - 1;
//                r++;
//                l = r;
//                continue;
//            }
//            r++;
//        }
}
