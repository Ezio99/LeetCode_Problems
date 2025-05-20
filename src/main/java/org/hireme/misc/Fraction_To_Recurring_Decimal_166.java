//package org.hireme.misc;
//
//public class Fraction_To_Recurring_Decimal_166 {
//    public String fractionToDecimal(int numerator, int denominator) {
//        int[] numbers;
//        boolean isRecurring;
//        double quotient = (double) numerator / denominator;
//        String result = quotient + "";
//        StringBuilder recurringNumbers = new StringBuilder();
//        int decimalIndex = result.indexOf('.'), lastValue = 0;
//
//        if (result.substring(decimalIndex + 1).length() == 1 && result.charAt(decimalIndex + 1) == '0') {
//            result = result.substring(0, decimalIndex);
//        } else {
//            numbers = new int[9];
//            for (int i = decimalIndex + 1; i < result.length(); i++) {
//                numbers[result.charAt(i) - '0'] += 1;
//            }
//
//            for (int i = 0; i < numbers.length; i++) {
//                if (numbers[i] != 0 && numbers[i] != lastValue) {
//                    isRecurring = false;
//                    break;
//                }
//                if (numbers[i] > 0) {
//                    recurringNumbers.append(i);
//                }
//            }
//
//
//            if (isRecurring) {
//                result = result.substring(0, decimalIndex + 1) + "(" + recurringNumbers + ")";
//            }
//        }
//
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Fraction_To_Recurring_Decimal_166 obj = new Fraction_To_Recurring_Decimal_166();
//        System.out.println(obj.fractionToDecimal(2, 1));
//        System.out.println(obj.fractionToDecimal(4, 333));
//        System.out.println(obj.fractionToDecimal(1, 2));
//        System.out.println(obj.fractionToDecimal(2, 3));
//    }
//}
