package org.hireme.leetcode.SlidingWindow.Variable;

public class Longest_Repeating_Replacement {
    public int characterReplacement(String s, int k) {
        int[] characterFrequency = new int[26];
//        Instead of tracking maxChar track maxFrequency, we dont need to update the var incase it goes down as that will
//        always result in a smaller valid window, only when maxfrquency goes up do we track it
        int maxFreq = 1;
        characterFrequency[s.charAt(0) - 'A'] = 1;


        int l = 0, maxLength = 1;
        char currentChar;
        for (int r = 1; r < s.length(); r++) {
            currentChar = s.charAt(r);
            characterFrequency[currentChar - 'A'] += 1;


            if (characterFrequency[currentChar - 'A'] > maxFreq) {
                maxFreq = characterFrequency[currentChar - 'A'];
            }

            if (((r - l + 1) - maxFreq > k)) {
                while ((r - l + 1) - maxFreq > k) {
                    characterFrequency[s.charAt(l) - 'A'] -= 1;
                    l++;
                }
            }

            maxLength = Math.max((r - l + 1), maxLength);

        }

        return maxLength;


    }

    public static void main(String[] args) {
        Longest_Repeating_Replacement obj = new Longest_Repeating_Replacement();
        System.out.println(obj.characterReplacement("BAAA", 0));
    }
}
