package org.hireme.misc;

import java.util.BitSet;

public class Pangram_1832 {
    public boolean checkIfPangram(String sentence) {
        BitSet bitSet = new BitSet(26);
        int ctr = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (!bitSet.get(sentence.charAt(i) - 'a')) {
                bitSet.set(sentence.charAt(i) - 'a');
                ctr++;
                if (ctr == 26) {
                    return true;
                }
            }

        }

        return false;
    }

    public boolean checkIfPangramNoSpace(String sentence) {
        char ch = 'a';
        for (int i = 0; i < 26; i++) {
            if (!sentence.contains(String.valueOf(ch++))) {
                return false;
            }
        }
        return true;
    }

}
