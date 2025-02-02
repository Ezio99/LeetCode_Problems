package org.hireme.neetcode.FastSlowPointers;

import org.hireme.leetcode.LinkedList.ListNode;

public class Maximum_Twin_Sum_Of_LL_2130 {

    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, current = slow;
        while (current != null) {
            ListNode nextTmp = current.next;
            current.next = prev;
            prev = current;
            current = nextTmp;
        }

        ListNode current2 = prev, current1 = head;
        int result = -1, currSum;
        while (current2 != null) {
            currSum = current1.val + current2.val;
            if (currSum > result) {
                result = currSum;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case: [5, 4, 2, 1]
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        Maximum_Twin_Sum_Of_LL_2130 solution = new Maximum_Twin_Sum_Of_LL_2130();
        int result = solution.pairSum(head);

        System.out.println("Maximum Twin Sum: " + result);
        // Expected Output: 6 (5+1 or 4+2)
    }


}
