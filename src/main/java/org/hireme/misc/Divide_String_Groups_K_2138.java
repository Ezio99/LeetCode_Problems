package org.hireme.misc;

import java.util.Arrays;

public class Divide_String_Groups_K_2138 {
    public String[] divideString(String s, int k, char fill) {
        int padding = s.length() % k;
        int groups = (int) (Math.ceil(s.length() / (float) k));
        String[] result = new String[groups];
        int ctr = 0, i;
        for (i = 0; i < s.length() - padding; i += k) {
            result[ctr++] = s.substring(i, i + k);
        }

        if (padding != 0) {
            result[ctr] = s.substring(i) + Character.toString(fill).repeat(k - padding);
        }


        return result;
    }

    public static void main(String[] args) {
        Divide_String_Groups_K_2138 obj = new Divide_String_Groups_K_2138();
        System.out.println(Arrays.toString(obj.divideString("abcdefghij", 3, 'x')));
    }
}
