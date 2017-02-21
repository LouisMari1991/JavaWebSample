package com.sync.sz.web.servlet.calc;

import java.math.BigDecimal;

/**
 * 封装计算器数据的bean
 * Created by Administrator on 2017/2/21 0021.
 */
public class CalculatorBean {

  private String firstNum = "0";

  private String secondNum = "0";

  private char operator = '+';

  private String result;

  public String getFirstNum() {
    return firstNum;
  }

  public void setFirstNum(String firstNum) {
    this.firstNum = firstNum;
  }

  public String getSecondNum() {
    return secondNum;
  }

  public void setSecondNum(String secondNum) {
    this.secondNum = secondNum;
  }

  public char getOperator() {
    return operator;
  }

  public void setOperator(char operator) {
    this.operator = operator;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public void calculator() {
    BigDecimal first = new BigDecimal(firstNum);
    BigDecimal second = new BigDecimal(secondNum);
    switch (operator) {
      case '+': {
        result = first.add(second).toString();
        break;
      }
      case '-': {
        result = first.subtract(second).toString();
        break;
      }
      case '*': {
        result = first.multiply(second).toString();
        break;
      }
      case '/': {
        if (second.doubleValue() == 0) {
          throw new RuntimeException("被除数不能为0");
        }
        result = first.divide(second, 20, BigDecimal.ROUND_HALF_UP).toString();
        break;
      }
      default: {
        throw new RuntimeException("运算符只能是+-*//");
      }
    }
  }
}
