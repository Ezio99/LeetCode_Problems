package org.hireme.misc;

public class Remove_Outermost_Parentheses_1021 {
    public String removeOuterParentheses(String s) {
        if (s.isEmpty()) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        char ch;
        int outerCtr = 0, ctr = 0;
        while (ctr < s.length()) {
            ch = s.charAt(ctr);
            if (ch == '(') {
                if (outerCtr > 0) {
                    result.append(ch);
                }
                outerCtr++;
            } else {
                if (outerCtr > 1) {
                    result.append(ch);
                }
                outerCtr--;
            }
            ctr++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Remove_Outermost_Parentheses_1021 obj = new Remove_Outermost_Parentheses_1021();
        System.out.println(obj.removeOuterParentheses("(()())(())"));
    }
}
