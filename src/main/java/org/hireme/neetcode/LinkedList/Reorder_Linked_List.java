package org.hireme.neetcode.LinkedList;

import org.hireme.leetcode.LinkedList.ListNode;

import java.util.*;

public class Reorder_Linked_List {


    /**
     * TC O(n)
     * SC O(1)
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        //Mid point =slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse from slow
        ListNode prevNode = null, nextNode;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prevNode;
            prevNode = slow;
            slow = nextNode;
        }
        slow = prevNode;
        //Merge
        ListNode first = head, second = slow;
        ListNode tmp1, tmp2;
        while (second.next != null) {
            tmp1 = first.next;
            tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }


    }


    /**
     * Brute force
     * <p>
     * TC O(n)
     * SC O(n)
     **/
    public void reorderListBrute(ListNode head) {
        List<ListNode> arr = new ArrayList<>();
        ListNode curr = head.next;
        while (curr != null) {
            arr.add(curr);
            curr = curr.next;
        }

        int l = 0, r = arr.size() - 1;
        curr = head;
        while (l < r) {
            curr.next = arr.get(r--);
            curr = curr.next;
            curr.next = arr.get(l++);
            curr = curr.next;
        }
        if (l == r) {
            curr.next = arr.get(l);
            curr = curr.next;
        }
        curr.next = null;
    }
}
