package org.hireme.misc;

import java.util.*;

public class Max_Score_After_Removing_SubStrings_1717 {
    public int maximumGain(String s, int x, int y) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        char ch;
        int sum = 0;
        String[] patterns = new String[]{"ab", "ba"};
        int[][] arr = new int[][]{{x, 0}, {y, 1}};
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        String pattern;
        for (int[] j : arr) {
            pattern = patterns[j[1]];
            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i);
                if (ch != 'a' && ch != 'b') {
                    stack.push(ch);
                    continue;
                }

                if (!stack.isEmpty() && (stack.peek() + String.valueOf(ch)).equals(pattern)) {
                    stack.pop();
                    sum += j[0];
                } else {
                    stack.push(ch);
                }
            }
            sb.append(clearStack(stack));
            s = String.valueOf(sb);
            sb = new StringBuilder();
        }


        return sum;
    }

    private StringBuilder clearStack(Deque<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse();
    }

    public static void main(String[] args) {
        Max_Score_After_Removing_SubStrings_1717 obj = new Max_Score_After_Removing_SubStrings_1717();
        System.out.println(obj.maximumGain("cdbcbbaaabab", 4, 5));
        System.out.println(obj.maximumGain("cdbcbbaaabab", 4, 4));
    }
}
