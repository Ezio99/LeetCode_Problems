package org.hireme.misc;

public class Max_Score_After_Splitting_1422 {
    public static int maxScore(String s) {
        int l_score, r_score = 0, total = -1;
        l_score = s.charAt(0) == '0' ? 1 : 0;

        for (int i = 1; i < s.length(); i++) {
            r_score += s.charAt(i) == '0' ? 0 : 1;
        }
        total = l_score + r_score;



        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i)  == '1') {
                r_score -= 1;
                continue;
            } else {
                l_score += 1;
            }


            if (r_score + l_score > total) {
                total = r_score + l_score;
            }
        }

        return total;
    }

    public static int maxScoreOptimal(String s) {
        int n = s.length();
        int ons = 0;
        int curr = s.charAt(0) == '0' ? 1 : 0;
        int score = curr;

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                curr++;
            } else {
                ons++;
                curr--;
            }
            if (curr > score) {
                score = curr;
            }
        }
        ons += s.charAt(n - 1) == '1' ? 1 : 0;

        return ons + score;
    }

    public static void main(String[] args) {
        System.out.println(maxScoreOptimal("011101"));
        System.out.println(maxScore("1111"));
        System.out.println(maxScore("00"));
    }


}
