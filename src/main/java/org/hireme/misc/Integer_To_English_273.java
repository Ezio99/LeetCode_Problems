package org.hireme.misc;

public class Integer_To_English_273 {
    public String numberToWords(int num) {
        String[] belowTwenty = {
                "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        String[] tens = {
                "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        String[] thousands = {
                "Hundred", "Thousand", "Million", "Billion"
        };

        String s = String.valueOf(num);
        int length = s.length();
        StringBuilder sb = new StringBuilder();

        if(length==1){
            return belowTwenty[Integer.parseInt(s.charAt(0)+"")];
        }

        if(s.charAt(length-2)=='1'){
            sb.append(belowTwenty[Integer.parseInt(s.substring(length-2,length))]);
            sb.append(" ");
        }else{
            sb.append(belowTwenty[Integer.parseInt(s.substring(length-1))]);
            sb.append(" ");
            sb.append(tens[Integer.parseInt(s.substring(length-2,length-1))]);
            sb.append(" ");
        }

        int ctr=0;
        for(int i=length-3;i>=0;i--){
            sb.append(thousands[ctr++]);
            sb.append(" ");
            sb.append(belowTwenty[Integer.parseInt(s.substring(i,i+1))]);
            sb.append(" ");
        }

        return sb.toString();


    }

    public static void main(String[] args) {
        Integer_To_English_273 obj = new Integer_To_English_273();
        System.out.println(obj.numberToWords(12345));
    }
}
