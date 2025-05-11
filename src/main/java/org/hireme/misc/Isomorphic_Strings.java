package org.hireme.misc;


import java.util.BitSet;


//Bit set for 
public class Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {
        char[] mapping = new char[128]; // Number of ascii chars
//        boolean[] used = new boolean[128];
        BitSet used = new BitSet(128);

        char sc,tc;
        int pos;
        for(int i=0;i<s.length();i++){
            sc = s.charAt(i);
            tc = t.charAt(i);
            pos = sc;
            if(mapping[pos]!='\u0000'){
                if(mapping[pos]!=tc)
                    return false;
            }
            else if(used.get(tc)){
                return false;
            }
            else{
                mapping[pos]=tc;
                used.set(tc);
            }

        }
        return true;
    }
}
