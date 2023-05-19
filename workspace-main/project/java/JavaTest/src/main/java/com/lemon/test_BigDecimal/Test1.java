package com.lemon.test_BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test1 {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");

        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
        // System.out.println(a.divide(b));
        System.out.println(a.divide(b, 2, RoundingMode.HALF_UP));

        System.out.println(a.compareTo(b));

         a = new BigDecimal("1");
         b = new BigDecimal("1.0");
        System.out.println(a.equals(b));//false
    }
}
