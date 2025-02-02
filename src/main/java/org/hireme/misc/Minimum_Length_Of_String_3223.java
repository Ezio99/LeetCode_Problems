package org.hireme.misc;

import java.util.HashMap;

public class Minimum_Length_Of_String_3223 {

    public int minimumLength(String s) {
        int[] arr = new int[26];


        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 97]++;
        }

        int sum = 0;
        for (int ctr : arr) {
//            while (ctr >= 3) {
//                ctr = ctr / 3 + ctr % 3;
//            }
            if (ctr >= 3) {
                if (ctr % 2 == 0)
                    ctr = 2;
                else
                    ctr = 1;
            }
            sum += ctr;
        }

        return sum;
    }

//    public int minimumLength(String s) {
//        HashMap<Character, Integer> distinctCharCountMap = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            distinctCharCountMap.merge(s.charAt(i), 1, Integer::sum);
//        }
//
//        int sum = 0, ctr;
//        for (Character countChar : distinctCharCountMap.keySet()) {
//            ctr = distinctCharCountMap.get(countChar);
//            while (ctr >= 3) {
//                ctr = ctr / 3 + ctr % 3;
//            }
//            sum += ctr;
//        }
//
//        return sum;
//    }

    public static void main(String[] args) {
        Minimum_Length_Of_String_3223 obj = new Minimum_Length_Of_String_3223();
        System.out.println(obj.minimumLength("ucvbutgkohgbcobqeyqwppbxqoynxeuuzouyvmydfhrprdbuzwqebwuiejoxsxdhbmuaiscalnteocghnlisxxawxgcjloevrdcj"));
        System.out.println(obj.minimumLength("abaacbcbb"));


    }


}
