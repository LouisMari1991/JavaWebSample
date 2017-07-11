package com.sync.changsha.rxjava;

import org.junit.Test;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
public class StringTest {

  @Test
  public void findStr() {
    String str0 = "18664569168";
    String str1 = "456";
    int start = str0.indexOf(str1);
    System.out.println(start);
    System.out.println(str0.substring(start, start + str1.length()));
  }

}
