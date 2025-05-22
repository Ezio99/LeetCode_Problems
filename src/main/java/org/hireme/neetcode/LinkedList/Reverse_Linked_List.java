package org.hireme.neetcode.LinkedList;

import org.hireme.leetcode.LinkedList.ListNode;

public class Reverse_Linked_List {

    //Iterative
    public ListNode reverseList(ListNode head) {
        if(head ==null){
            return null;
        }
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode tmp;
        while(currNode!=null){
            tmp = currNode.next;
            currNode.next = prevNode;
            prevNode=currNode;
            currNode=tmp;
        }

        return prevNode;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        if (head.next != null) {
            newHead = reverseListRecursive(head.next);
            head.next.next = head;
        }
        head.next = null;

        return newHead;
    }


    public static void main(String[] args) {
        Reverse_Linked_List llr = new Reverse_Linked_List();

        int[] values = {1, 2, 3, 4, 5};
        ListNode head = ListNode.buildList(values);

        System.out.print("Original List: ");
        ListNode.printList(head);

        ListNode reversed = llr.reverseListRecursive(head);

        System.out.print("Reversed List: ");
        ListNode.printList(reversed);
    }
}
