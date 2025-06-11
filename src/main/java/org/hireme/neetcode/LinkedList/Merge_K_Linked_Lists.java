package org.hireme.neetcode.LinkedList;

import org.hireme.leetcode.LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Merge_K_Linked_Lists {

    public ListNode mergeKListsHeapOptimal(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }


        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // Add the first node of each list
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        //Only have k elements in heap at any time
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return head.next;
    }


    public ListNode mergeKListsHeap(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode minNode;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            ListNode curr = list;
            while (curr != null) {
                minHeap.offer(curr);
                curr = curr.next;
            }
        }

        minNode = minHeap.poll();
        ListNode head = minNode;
        while (!minHeap.isEmpty()){
            minNode.next=minHeap.poll();
            minNode=minNode.next;
        }
        if(minNode!=null){
            minNode.next=null;
        }

        return head;


    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        //Put minimum list in pos 0
        ListNode minNode = null, tmp;
        int pos = -1, minVal = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < minVal) {
                minNode = lists[i];
                minVal = minNode.val;
                pos = i;
            }
        }

        if (minNode == null) {
            return null;
        }

        if (pos != 0) {
            tmp = lists[pos];
            lists[pos] = lists[0];
            lists[0] = tmp;
        }

        ListNode head = lists[0];
        minNode = lists[0];
        lists[0] = lists[0].next;


        ListNode currMinNode = null;
        int currMinValue = 0;
        while (true) {
            currMinValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < currMinValue) {
                    currMinNode = lists[i];
                    currMinValue = currMinNode.val;
                    pos = i;
                }
            }
            if (currMinValue == Integer.MAX_VALUE) {
                break;
            }
            minNode.next = currMinNode;
            minNode = currMinNode;
            lists[pos] = lists[pos].next;
        }

        return head;
    }
}
