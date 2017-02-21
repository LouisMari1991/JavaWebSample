package com.sync.sz.web.servlet.calc;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Administrator on 2017/2/21 0021.
 */
public class Demo1 {

  public static void main(String[] args) {
    //double a = 0.1;
    //double b = 0.006;
    //System.out.println(a + b);

    BigDecimal a = new BigDecimal("0.1");
    BigDecimal b = new BigDecimal("0.0000013156498465146549846516");
    System.out.println(a.add(b));
    System.out.println(a.multiply(b));
    System.out.println(a.divide(b, 10, BigDecimal.ROUND_HALF_UP));
  }
}
