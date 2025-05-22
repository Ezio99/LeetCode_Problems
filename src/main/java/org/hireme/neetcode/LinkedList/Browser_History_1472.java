package org.hireme.neetcode.LinkedList;

import org.hireme.leetcode.LinkedList.ListNode;

//Double linked list
public class Browser_History_1472 {

    static class BrowserNode {
        String val;
        BrowserNode prev;
        BrowserNode next;

        public BrowserNode() {
        }

        public BrowserNode(String val) {
            this.val = val;
        }
    }

    BrowserNode head;
    BrowserNode tail;
    BrowserNode curr;

    public Browser_History_1472(String homepage) {
        head = new BrowserNode();
        tail = new BrowserNode();
        curr = new BrowserNode(homepage);
        head.next = curr;
        tail.prev = curr;
        curr.prev = head;
        curr.next = tail;
    }

    public void visit(String url) {
        BrowserNode visitNode = new BrowserNode(url);
        curr.next = visitNode;
        visitNode.next = tail;
        tail.prev = visitNode;
        visitNode.prev = curr;
        curr = visitNode;
    }

    public String back(int steps) {
        while (curr.prev != head && steps != 0) {
            curr = curr.prev;
            steps--;
        }

        return curr.val;
    }

    public String forward(int steps) {
        while (curr.next != tail && steps != 0) {
            curr = curr.next;
            steps--;
        }

        return curr.val;
    }
}
