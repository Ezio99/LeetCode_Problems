package org.hireme.misc;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class Find_Winner_Circular_Game_1823 {
    public int findTheWinner(int n, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int curr;

        for (int i = 0; i < n; i++) {
            deque.offer(i);
        }

        while (deque.size() > 1) {
            for (int i = 0; i < k-1; i++) {
                curr = deque.pop();
                deque.offer(curr);
            }
            deque.poll();
        }


        return deque.pop()+1;
    }

    public static void main(String[] args) {
        Find_Winner_Circular_Game_1823 obj = new Find_Winner_Circular_Game_1823();
        System.out.println(obj.findTheWinner(5, 2));
    }
}
