package org.hireme;

//Circular array
class MyCircularDeque {

    private int[] data;
//    front points to the actual front element
    private int front;
//    rear points to the next available slot
    private int rear;
    private int size;

    public MyCircularDeque(int k) {
        data = new int[k + 1];
        size = k + 1;
        front = 0;
        rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;

        //Move front back
        //2-1+5=6%5=1
        //0-1+5=4%5=4
        front = (front - 1 + size) % size;
        data[front] = value;
        return true;

    }

    public boolean insertLast(int value) {
        if (isFull()) return false;

        data[rear] = value;
        //Move rear back
        rear = (rear + 1) % size;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;

        //Move front forward
        front = (front + 1) % size;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;

        //Move rear back
        rear = (rear - 1 + size) % size;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;

        return data[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;

        return data[(rear - 1 + size) % size];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
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
