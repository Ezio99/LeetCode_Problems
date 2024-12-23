package org.hireme.playground.Recursion;

public class String_Reverse_Outside_In {
    public static String reverse(String str,int ctr){
        if(ctr>=str.length()/2){
            if(str.length()%2==0)
                return "";
            return String.valueOf(str.charAt(ctr));
        }

        return str.charAt(str.length()-1-ctr)+reverse(str,ctr+1)+str.charAt(ctr);
    }

    public static boolean checkPalindrome(String str,int ctr){
        if(ctr>=str.length()/2){
            return true;
        }
        if(Character.toLowerCase(str.charAt(str.length()-1-ctr))!=Character.toLowerCase(str.charAt(ctr))){
            return false;
        }

        return checkPalindrome(str,ctr+1);
    }

    public static void main(String[] args) {
        System.out.println(reverse("Hello",0));
        System.out.println(reverse("Hell",0));
        System.out.println(checkPalindrome("Hell",0));
        System.out.println(checkPalindrome("HeH",0));
    }
}
