package com.sync.sz.sample.dao.impl;

import com.sync.sz.sample.domain.User;
import java.util.Date;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/2/25 0025.
 */
public class UserDaoImplTest {
  @Test
  public void add() throws Exception {
    User user = new User();
    user.setBirthday(new Date());
    user.setEmail("aa@sina.com");
    user.setId("123213213");
    user.setPassword("123");
    user.setNickname("xiaoming");
    user.setUsername("heihei");

    UserDaoImpl dao = new UserDaoImpl();
    dao.add(user);
  }

  @Test
  public void find() throws Exception {

  }

  @Test
  public void find1() throws Exception {

  }
}