package org.hireme.neetcode.FastSlowPointers;

import org.hireme.leetcode.LinkedList.ListNode;

public class LL_Cycle_Detect {
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (slowPointer.next != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(fastPointer==null){
                break;
            }

            if (slowPointer.val == fastPointer.val) {
                return true;
            }
        }

        return false;
    }
}
