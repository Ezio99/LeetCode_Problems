package org.hireme.neetcode.twopointer;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        s = s.trim().toLowerCase();
        int R = s.length()-1;

        for(int L=0;L<R;){
            if(!Character.isLetterOrDigit(s.charAt(L))){
                L++;
                continue;
            } else if (!Character.isLetterOrDigit(s.charAt(R))) {
                R--;
                continue;
            } else if (Character.toLowerCase(s.charAt(L)) != Character.toLowerCase(s.charAt(R))) {
                return false;
            }

            L++;R--;
        }


        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("tab a cat"));
    }
}
