package org.hireme.neetcode.string;

import java.util.ArrayList;
import java.util.List;

public class Encode_And_Decode {
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            result.append(s.length()).append(":").append(s);
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        StringBuilder num = new StringBuilder();
        char ch;
        int currLen;
        for (int i = 0; i < str.length(); ) {
            ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                num.append(ch);
                i++;
            } else if (ch == ':') {
                currLen = Integer.parseInt(num.toString());
                result.add(str.substring(i + 1, i + currLen + 1));
                i = i + currLen + 1;
                num = new StringBuilder();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Encode_And_Decode obj = new Encode_And_Decode();
        List<String> arr = new ArrayList<>();
        arr.add("we");
        arr.add("say");
        arr.add(":");
        arr.add("yes");
        String x = obj.encode(arr);
        System.out.println(x);
        System.out.println(obj.decode(x));
    }
}
