package org.hireme.misc;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRU_Cache_146 {

    int capacity;
    CustomLinkedHashMap store;


    public LRU_Cache_146(int capacity) {
        this.capacity = capacity;
        store = new CustomLinkedHashMap();
    }

    public int get(int key) {
        if (store.get(key) != null) {
            int val = store.remove(key);
            store.putLast(key, val);
            return store.get(key);
        }

        return -1;

    }

    public void put(int key, int value) {
        if (store.get(key) != null) {
            store.putLast(key, value);
            return;
        }

        if (store.size() == capacity) {
            store.removeFirst();
        }

        store.putLast(key, value);

    }


    static class CustomLinkedHashMap {

        //Node for double linked list
        static class LinkedNode {
            int val;
            int key;
            LinkedNode before;
            LinkedNode after;

            LinkedNode(int key, int val) {
                this.key = key;
                this.val = val;
            }


        }

        HashMap<Integer, LinkedNode> mapStore;
        LinkedNode head;
        LinkedNode tail;
        final Integer HEAD_KEY = -1;

        public CustomLinkedHashMap() {
            head = new LinkedNode(HEAD_KEY, -1);
            mapStore = new HashMap<>();
            mapStore.put(HEAD_KEY, head);
            tail = head;
        }

        public void putLast(int k, int v) {
            if (mapStore.get(k) != null) {
                LinkedNode currentNode = mapStore.get(k);
                LinkedNode beforeCurrent = currentNode.before;
                if (currentNode != tail) {
                    beforeCurrent.after = currentNode.after;
                    currentNode.after.before = beforeCurrent;
                    tail.after = currentNode;
                    currentNode.before = tail;
                    tail = currentNode;
                }
                currentNode.val = v;
            } else {
                LinkedNode node = new LinkedNode(k, v);
                mapStore.put(k, node);
                tail.after = node;
                node.before = tail;
                tail = node;
            }
        }

        public Integer remove(int k) {
            if (mapStore.get(k) == null) {
                return null;
            }
            LinkedNode removalNode = mapStore.get(k);
            LinkedNode beforeCurrent = removalNode.before;
            beforeCurrent.after = removalNode.after;
            if (tail == removalNode) {
                tail = beforeCurrent;
            } else {
                removalNode.after.before = beforeCurrent;
            }

            mapStore.remove(k);
            return removalNode.val;
        }

        public Integer get(int k) {
            if (mapStore.get(k) == null) {
                return null;
            }

            return mapStore.get(k).val;
        }

        public Integer size() {
            //Removing head count
            return this.mapStore.size() - 1;
        }

        public Integer removeFirst() {
            LinkedNode firstNode = head.after;

            if (firstNode == null) {
                return null;
            }

            if (tail == firstNode) {
                head.after = null;
                tail = head;
            } else {
                head.after = firstNode.after;
                firstNode.before = head;
                firstNode.after.before = head;
            }

            mapStore.remove(firstNode.key);

            return firstNode.val;

        }


    }

    public static void main(String[] args) {
        LRU_Cache_146 obj = new LRU_Cache_146(3);
        obj.put(1, 1);
        obj.put(2, 2);
        obj.put(3, 3);
        obj.put(4, 4);
        System.out.println(obj.get(4));
        System.out.println(obj.get(3));
        System.out.println(obj.get(2));
        System.out.println(obj.get(1));
        obj.put(5,5);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
        System.out.println(obj.get(5));
    }
}
