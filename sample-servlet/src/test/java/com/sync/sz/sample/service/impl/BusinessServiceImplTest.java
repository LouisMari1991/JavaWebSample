package com.sync.sz.sample.service.impl;

import com.sync.sz.sample.dao.impl.UserDaoImpl;
import com.sync.sz.sample.domain.User;
import java.util.Date;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/2/25 0025.
 */
public class BusinessServiceImplTest {
  @Test
  public void regiester() throws Exception {
    User user = new User();
    user.setBirthday(new Date());
    user.setEmail("aa@sina.com");
    user.setId("123213213");
    user.setPassword("123");
    user.setNickname("xiaoming");
    user.setUsername("heihei");

    BusinessServiceImpl service = new BusinessServiceImpl();
    service.regiester(user);
  }

  @Test
  public void login() throws Exception {
    BusinessServiceImpl service = new BusinessServiceImpl();
    System.out.println(service.login("heihei", "123"));
  }
}