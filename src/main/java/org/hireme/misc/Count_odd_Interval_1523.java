package org.hireme.misc;

public class Count_odd_Interval_1523 {
    public int countOdds(int low, int high) {
        boolean isOdd1=low%2!=0;
        boolean isOdd2=high%2!=0;
        if(isOdd1 || isOdd2){
            if(isOdd1 && isOdd2){
                return (int) (2 + Math.floor((high-low-1)/2.0));
            }
            return (int) (1 + Math.floor((high-low-1)/2.0));
        }
        return (int) (Math.ceil((high-low-1)/2.0));

    }
}
