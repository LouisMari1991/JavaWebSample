package com.sync.changsha.gson.bean;

/**
 * Created by Administrator on 2017/12/5.
 */
public class MockBean {

  private String name;
  private String age;
  private String nick;
  private String phone;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getNick() {
    return nick;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override public String toString() {
    return "MockBean{" +
        "name='" + name + '\'' +
        ", age='" + age + '\'' +
        ", nick='" + nick + '\'' +
        ", phone='" + phone + '\'' +
        '}';
  }
}
