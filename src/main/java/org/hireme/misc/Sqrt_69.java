package org.hireme.misc;

public class Sqrt_69 {

    public int mySqrt(int x) {
        if(x==1) return 1;
        int l=0,r=Math.min(46341,x);
        int m=0,ans=0;

        while(l<=r){
            m = l + (r-l)/2;
            long sq = (long) m * m;

            if (sq == x) return m;
            if (sq < x) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }

        }


        return ans;

    }
}
