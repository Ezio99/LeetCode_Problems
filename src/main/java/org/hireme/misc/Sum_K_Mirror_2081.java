package org.hireme.misc;

public class Sum_K_Mirror_2081 {
    public long kMirror(int k, int n) {
        return 0;
    }

    public StringBuilder convertBaseK(int n, int k) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            s.append(n % k);
            n /= k;
        }

        return s;
    }

    public static void main(String[] args) {
        Sum_K_Mirror_2081 obj = new Sum_K_Mirror_2081();
        System.out.println(obj.convertBaseK(121,3));
    }
}
