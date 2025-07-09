package org.hireme.misc;

public class Max_Difference_1432 {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        int a = num, b = num;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                a = Integer.parseInt(s.replace(s.charAt(i), '9'));
                break;
            }
        }

        if (s.charAt(0) != '1') {
            b = Integer.parseInt(s.replace(s.charAt(0), '1'));
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                    b = Integer.parseInt(s.replace(s.charAt(i), '0'));
                    break;
                }
            }
        }


        return a - b;
    }

    public static void main(String[] args) {
        Max_Difference_1432 obj = new Max_Difference_1432();
        System.out.println(obj.maxDiff(555));
        System.out.println(obj.maxDiff(123456));
        System.out.println(obj.maxDiff(111));
        System.out.println(obj.maxDiff(1101057));
    }
}
