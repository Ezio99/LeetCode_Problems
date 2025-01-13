package org.hireme.datastructure.sorting;

import java.util.ArrayList;
import java.util.List;


/*
Given a list of key-value pairs, sort the list by key using Insertion Sort. Return a list of lists showing the state of the array
after each insertion. If two key-value pairs have the same key, maintain their relative order in the sorted list

Input:
pairs = [(5, "apple"), (2, "banana"), (9, "cherry")]

Output:
[[(5, "apple"), (2, "banana"), (9, "cherry")],
 [(2, "banana"), (5, "apple"), (9, "cherry")],
 [(2, "banana"), (5, "apple"), (9, "cherry")]]

 */
public class InsertionSort {

    public static List<List<Pair>> insertionSort(List<Pair> pairs) {
        if(pairs.isEmpty()){
            return new ArrayList<>();
        }

        List<List<Pair>> result = new ArrayList<>();
        int j;
        Pair tmp;


        for (int i = 1; i < pairs.size(); i++) {
            result.add(new ArrayList<>(pairs));
            j = i - 1;
            while (j >= 0 && pairs.get(j).key > pairs.get(j+1).key) {
                tmp = pairs.get(j);
                pairs.set(j, pairs.get(j+1));
                pairs.set(j+1, tmp);
                j--;
            }
        }

        return result;
    }


    static class Pair {
        int key;
        String value;

        Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return String.format("(%d, %s)",this.key,this.value);
        }
    }

    public static void main(String[] args) {
        List<Pair> pairs = new ArrayList<>();

        pairs.add(new Pair(5,"apple"));
        pairs.add(new Pair(2,"banana"));
        pairs.add(new Pair(9,"cherry"));

        insertionSort(pairs).forEach(x->x.forEach(y -> System.out.print(y.toString())));
    }
}
