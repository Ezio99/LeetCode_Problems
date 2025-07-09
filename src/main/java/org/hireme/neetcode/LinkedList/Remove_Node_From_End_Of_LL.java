package org.hireme.neetcode.LinkedList;

import org.hireme.leetcode.LinkedList.ListNode;

public class Remove_Node_From_End_Of_LL {

    ListNode globalHead;

    public ListNode removeNthFromEndRecursion(ListNode head, int n) {
        globalHead = head;
        recurse(head, n);
        return globalHead;
    }

    public int recurse(ListNode node, int n) {
        if (node.next == null) {
            if (node == globalHead) {
                globalHead = globalHead.next;
            }
            return 0;
        }

        int x = 1 + recurse(node.next, n);

        if (x == n) {
            ListNode curr = node;
            ListNode tmp = curr.next;
            curr.next = tmp.next;
            tmp.next = null;
        } else if (x == n - 1 && node == globalHead) {
            globalHead = globalHead.next;
        }

        return x;

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int ctr = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            ctr++;
        }
        int removalIndex = ctr - n;

        if (removalIndex == 0) {
            return head.next;
        }
        curr = head;
        for (int i = 0; i < removalIndex - 1; i++) {
            curr = curr.next;
        }
        ListNode tmp = curr.next;
        curr.next = tmp.next;
        tmp.next = null;

        return head;

    }
}
