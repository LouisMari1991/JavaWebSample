package com.sync.sz.web.servlet.domain;

import java.util.Date;

/**
 * Created by Administrator on 2017/2/20 0020.
 */
public class Person {

  private String name = "aaa"; //getClass()
  private int age;
  private Date birthday;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
}
