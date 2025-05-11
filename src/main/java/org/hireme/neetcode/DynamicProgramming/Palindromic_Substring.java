package org.hireme.neetcode.DynamicProgramming;

public class Palindromic_Substring {

    public int countSubstrings(String s) {
        int ctr = 0;

        int l, r;

        //Odd Palindromes
        for (int i = 0; i < s.length(); i++) {
            l = i;
            r = i;

            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    ctr++;
                    l--;
                    r++;
                } else {
                    break;
                }

            }
        }


        //Even palindromes
        for (int i = 0; i < s.length(); i++) {
            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    ctr++;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }

        return ctr;

    }


    public static void main(String[] args) {
        Palindromic_Substring obj = new Palindromic_Substring();
        System.out.println(obj.countSubstrings("fldkls"));
    }


}
