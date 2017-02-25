package com.sync.sz.sample.dao.impl;

import com.sync.sz.sample.domain.User;
import com.sync.sz.sample.utils.XmlUtils;
import java.text.SimpleDateFormat;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 * Created by Administrator on 2017/2/24 0024.
 */
public class UserDaoImpl {

  public void add(User user) {

    try {
      Document document = XmlUtils.getDocument();
      Element root = document.getRootElement();

      Element user_tag = root.addElement("user");
      user_tag.setAttributeValue("id", user.getId());
      user_tag.setAttributeValue("username", user.getUsername());
      user_tag.setAttributeValue("password", user.getPassword());
      user_tag.setAttributeValue("email", user.getEmail());
      user_tag.setAttributeValue("birthday", user.getBirthday() == null ? "" : user.getBirthday().toLocaleString());
      user_tag.setAttributeValue("nickname", user.getNickname());

      XmlUtils.write2Xml(document);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 登录
   */
  public User find(String username, String password) {
    try {
      Document document = XmlUtils.getDocument();
      Element e = (Element) document.selectSingleNode("//user[@username='" + username + "' and @password='" + password + "']");
      if (e == null) {
        return null;
      }
      User user = new User();
      String date = e.attributeValue("birthday");
      if (date == null || date.equals("")) {
        user.setBirthday(null);
      } else {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(df.parse(date));
      }
      user.setEmail(e.attributeValue("email"));
      user.setId(e.attributeValue("id"));
      user.setNickname(e.attributeValue("nickname"));
      user.setPassword(e.attributeValue("password"));
      user.setUsername(e.attributeValue("username"));
      return user;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 用户是否存在
   */
  public boolean find(String username) {
    try {

      Document document = XmlUtils.getDocument();
      Element e = (Element) document.selectSingleNode("//user[@username='" + username + "']");
      if (e == null) {
        return false;
      } else {
        return true;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
