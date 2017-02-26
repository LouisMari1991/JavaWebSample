package com.sync.sz.sample.form;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class RegisterForm {

  private String username;
  private String password;
  private String password2;
  private String email;
  private String birthday;
  private String nickname;
  private String checkcode;

  private Map<String, String> errors = new HashMap<>();

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword2() {
    return password2;
  }

  public void setPassword2(String password2) {
    this.password2 = password2;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getCheckcode() {
    return checkcode;
  }

  public void setCheckcode(String checkcode) {
    this.checkcode = checkcode;
  }

  public Map getErrors() {
    return errors;
  }

  public void setErrors(Map errors) {
    this.errors = errors;
  }

  public boolean validate() {
    boolean isOK = true;
    if (username == null || username.trim().equals("")) {
      isOK = false;
      errors.put("username", "用户名不能为空!!");
    } else if (!username.matches("[A-Za-z]{3,8}")) {
      isOK = false;
      errors.put("username", "用户名必须为3到8位字母");
    }

    if (password == null || password.trim().equals("")) {
      isOK = false;
      errors.put("password", "密码不能为空!!");
    } else if (!password.matches("\\d{3,8}")) {
      errors.put("password", "密码必须为3到8位数字!!");
    }

    if (password2 == null || password2.trim().equals("")) {
      isOK = false;
      errors.put("password2", "确认密码不能为空!!");
    } else if (password.equals(password2)) {
      isOK = false;
      errors.put("password2", "两次密码要一致!!");
    }
    if (email == null || email.trim().equals("")) {
      isOK = false;
      errors.put("email", "邮箱不能为空!!");
    } else if (email.matches("\\\\w+@\\\\w+(\\\\.\\\\w+)+")) {
      isOK = false;
      // \\w+@\\w+(\\.\\w+)+
      errors.put("email", "邮箱格式不对!!");
    }

    if (birthday != null && !this.birthday.trim().equals("")) {
      try {
        DateLocaleConverter dic = new DateLocaleConverter();
        dic.convert(birthday, "yyyy-MM-dd");
      } catch (Exception e) {
        isOK = false;
        errors.put("birthday", "日期格式不对!!");
      }
    }

    if (nickname == null || nickname.trim().equals("")) {
      isOK = false;
      errors.put("nickname", "昵称不能为空!!");
    } else if (nickname.matches("[\u4e00-\u9fa5]+")) {
      isOK = false;
      errors.put("nickname", "昵称必须是汉字!!");
    }

    return isOK;
  }
}
