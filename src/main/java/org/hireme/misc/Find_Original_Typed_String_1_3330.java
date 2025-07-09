package org.hireme.misc;

public class Find_Original_Typed_String_1_3330 {
    public int possibleStringCountOptimal(String word) {
        int ctr = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) ctr++;
        }

        return ctr;
    }

    public int possibleStringCountSlidingWindow(String word) {
        int ctr = 1, curr = 0;
        int l = 0, r = 1;
        while (r < word.length()) {
            if (word.charAt(r) != word.charAt(l)) {
                l = r;
                ctr += curr;
                curr = 0;
            } else {
                curr++;
            }
            r++;
        }
        ctr += curr;

        return ctr;
    }

    public static void main(String[] args) {
        Find_Original_Typed_String_1_3330 obj = new Find_Original_Typed_String_1_3330();
//        System.out.println(obj.possibleStringCount("abbcccc"));
//        System.out.println(obj.possibleStringCount("abcd"));
//        System.out.println(obj.possibleStringCount("aaaa"));
    }
}
