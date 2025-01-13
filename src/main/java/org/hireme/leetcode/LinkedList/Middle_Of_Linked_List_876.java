package org.hireme.leetcode.LinkedList;

public class Middle_Of_Linked_List_876 {
    public ListNode middleNode(ListNode head) {
        ListNode middle = head;

        if (head.next == null) {
            return middle;
        }

        head = head.next;
        if (head.next == null) {
            return head;
        }

        int ctr = 0;
        while (head.next != null) {
            head = head.next;
            if (ctr % 2 == 0) {
                middle = middle.next;
            }
            ctr++;
        }

        if ((ctr + 2) % 2 == 0) {
            return middle.next;
        }

        return middle;

    }

    public ListNode middleNodeSimpler(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Move fast by two steps and slow by one step until fast reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Slow is now at the middle
    }
}
