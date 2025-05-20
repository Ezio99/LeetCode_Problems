package org.hireme.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LRU_Cache_146 {

    int capacity;
    LinkedHashMap<Integer, Integer> store;
//    LinkedHashSet<Integer> order;


    public LRU_Cache_146(int capacity) {
        this.capacity = capacity;
        store = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (store.get(key) != null) {
            int val = store.remove(key);
            store.putLast(key,val);
            return store.get(key);
        }

        return -1;

    }

    public void put(int key, int value) {
        if(store.get(key)!=null){
            store.putLast(key,value);
            return;
        }

        if (store.size() == capacity) {
            int removedKey = store.keySet().iterator().next();
            store.remove(removedKey);
        }

        store.putLast(key, value);

    }

    public static void main(String[] args) {
        LRU_Cache_146 obj = new LRU_Cache_146(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}
