package org.hireme.datastructure;

public class MyCircularDeque_LL {

    public static class Node {
        int val;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    Node tail;
    int capacity;
    int numNodes;

    public MyCircularDeque_LL(int k) {
        capacity = k;
        numNodes = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node frontNode = new Node(value);
        frontNode.next = head.next;
        frontNode.prev = head;
        head.next.prev = frontNode;
        head.next = frontNode;
        numNodes++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node lastNode = new Node(value);
        lastNode.next = tail;
        lastNode.prev = tail.prev;
        tail.prev.next = lastNode;
        tail.prev = lastNode;
        numNodes++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        Node deleteNode = head.next;
        deleteNode.next.prev = head;
        head.next = deleteNode.next;
        numNodes--;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        Node deleteNode = tail.prev;
        deleteNode.prev.next = tail;
        tail.prev = deleteNode.prev;
        numNodes--;

        return true;

    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return head.next.val;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return tail.prev.val;

    }

    public boolean isEmpty() {
        return numNodes == 0;
    }

    public boolean isFull() {
        return numNodes == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
