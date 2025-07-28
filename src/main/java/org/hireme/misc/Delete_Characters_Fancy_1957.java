package org.hireme.misc;

public class Delete_Characters_Fancy_1957 {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        char currChar = s.charAt(0), ch;
        int ctr = 1;
        for (int i = 1; i < s.length(); i++) {
            ch = s.charAt(i);
            if (currChar == ch) {
                ctr++;
                if (ctr > 2) continue;
            } else {
                ctr = 1;
                currChar = ch;
            }
            ans.append(ch);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Delete_Characters_Fancy_1957 obj = new Delete_Characters_Fancy_1957();
        System.out.println(obj.makeFancyString("leeetcode"));
        System.out.println(obj.makeFancyString("aaabaaaa"));
    }
}
