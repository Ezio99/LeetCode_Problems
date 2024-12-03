package org.hireme.graph.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TownJudge_997 {

    public static int findJudge(int n, int[][] trust) {
        int[] isTrust = new int[n];

        for(int[] trustRelation: trust){
            isTrust[trustRelation[0]-1]+=n+1;
            isTrust[trustRelation[1]-1]++;
        }

        for(int i=0;i<n;i++){
            if(isTrust[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int [][] trust = new int[][]{};
//        findJudge(3,)
    }
}
