package org.hireme.neetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Anagram {

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();

        for (String s : strs) {
            boolean added=false;
                for (List<String> sampleList : ans) {
                    if (s.length() == sampleList.get(0).length()) {
                        boolean flag = true;
                        for (int i = 0; i < sampleList.get(0).length(); i++) {
                            if (!sampleList.get(0).contains(s.substring(i,i+1))) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            sampleList.add(s);
                            added=true;
                            break;
                        }
                    }

                }
                if(!added){
                    List<String> x = new ArrayList<>();
                    x.add(s);
                    ans.add(x);
                }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
    }
}
