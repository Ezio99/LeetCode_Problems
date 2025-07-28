package org.hireme.misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid_Word_3136 {

    private static final Pattern NO_SPECIAL_CHARS = Pattern.compile("[^a-z0-9]");
    private static final Pattern VOWEL_PATTERN = Pattern.compile("[aeiou]");
    private static final Pattern CONSONANT_PATTERN = Pattern.compile("[^aeiou0-9]");


    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        word = word.toLowerCase();

        boolean hasConsonant = false, hasVowel = false;
        char ch;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (Character.isLetterOrDigit(ch)) return false;

            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        if (!hasVowel || !hasConsonant) {
            return false;
        }

        return true;
    }


    public boolean isValidRegex(String word) {
        if (word.length() < 3) return false;

        word = word.toLowerCase();


        Matcher matcher = NO_SPECIAL_CHARS.matcher(word);

        if (matcher.find()) return false;

        Matcher vowelMatcher = VOWEL_PATTERN.matcher(word);

        if (!vowelMatcher.find()) return false;


        Matcher consonantMatcher = CONSONANT_PATTERN.matcher(word);

        if (!consonantMatcher.find()) return false;


        return true;
    }


    public static void main(String[] args) {
        Valid_Word_3136 obj = new Valid_Word_3136();
        System.out.println(obj.isValid("56rty"));
        System.out.println(obj.isValid("56rty+"));
    }
}
