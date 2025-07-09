package org.hireme.misc;

import java.util.ArrayList;
import java.util.List;

public class Lexicographically_Largest_String_Box_1_3403 {

    String max = "";

    public String answerString(String word, int numFriends) {
        dfs(0, numFriends - 1, new ArrayList<>(), word);
        return max;
    }

    public void dfs(int pos, int cutsLeft, List<Integer> cuts, String word) {
        if (cutsLeft == 0) {
            int prev = 0;
            for (int cut : cuts) {
                if (word.substring(prev, cut).compareTo(max) > 0) {
                    max = word.substring(prev, cut);
                }
                prev = cut;
            }
            if (word.substring(prev).compareTo(max) > 0) {
                max = word.substring(prev);
            }
            return;
        }

        int i = pos + 1;
        while (i <= word.length() - cutsLeft) {
            cuts.add(i);
            dfs(i, cutsLeft - 1, cuts, word);
            cuts.removeLast();
            i++;
        }
    }

    public static void main(String[] args) {
        Lexicographically_Largest_String_Box_1_3403 obj = new Lexicographically_Largest_String_Box_1_3403();
        System.out.println(obj.answerString("dbca", 2));
    }
}
