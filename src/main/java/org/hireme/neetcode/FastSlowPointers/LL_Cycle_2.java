package org.hireme.neetcode.FastSlowPointers;

import org.hireme.leetcode.LinkedList.ListNode;

public class LL_Cycle_2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle=false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle=true;
                break;
            }
        }

        if(!isCycle){
            return null;
        }

        ListNode slow2 = head;
        while (slow2 != slow) {
            slow2 = slow2.next;
            slow = slow.next;
        }

        return slow;

    }
}
