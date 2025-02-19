package org.hireme.neetcode.DynamicProgramming;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        int[] maxIndex = new int[]{0, 0};
        int n = s.length();

        int ctr = 0;
        while (ctr < n) {
            findMaxPalindrome(ctr, ctr, n, maxIndex, s);
            findMaxPalindrome(ctr, ctr + 1, n, maxIndex, s);
            ctr++;
        }
        return s.substring(maxIndex[0], maxIndex[1] + 1);

    }

    private void findMaxPalindrome(int l, int r, int n, int[] maxIndex, String s) {
        while (l > -1 && r < n) {
            if (s.charAt(l) == s.charAt(r)) {
                if (r - l > maxIndex[1] - maxIndex[0]) {
                    maxIndex[0] = l;
                    maxIndex[1] = r;
                }
            } else {
                break;
            }
            l--;
            r++;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        System.out.println(obj.longestPalindrome("abaab"));
    }

}
