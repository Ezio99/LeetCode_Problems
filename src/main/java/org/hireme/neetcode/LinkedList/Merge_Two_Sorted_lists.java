package org.hireme.neetcode.LinkedList;

import org.hireme.leetcode.LinkedList.ListNode;

public class Merge_Two_Sorted_lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list2.val < list1.val) {
            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        ListNode newHead = list1;

        while (list1 != null && list2 != null) {
            ListNode prev = null;

            while (list1 != null && list1.val <= list2.val) {
                prev = list1;
                list1 = list1.next;
            }

            prev.next = list2;

            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;

        }

        return newHead;


    }

    public static void main(String[] args) {
        Merge_Two_Sorted_lists obj = new Merge_Two_Sorted_lists();

        int[] values = {1, 2, 4};
        ListNode list1 = ListNode.buildList(values);

        int[] values2 = {1, 3, 4};
        ListNode list2 = ListNode.buildList(values2);


        ListNode reversed = obj.mergeTwoLists(list1, list2);

        System.out.print("Reversed List: ");
        ListNode.printList(reversed);
    }
}
