package org.hireme.neetcode.FastSlowPointers;

import org.hireme.leetcode.LinkedList.ListNode;

public class Middle_of_Linked_List {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
